package com.example.demo.service;

import com.example.demo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeClassPagination {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> searchEmployees(
            String department, Double salary,

            //pagination
            int page, int size,

            //Sorting
            String sortBy,
            String direction

    ){
        //Step1: Get CriteriaBuilder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //Step2: Create Query
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        //Step3: Select Table
        Root<Employee> root = query.from(Employee.class);
        //Step4: Dynamic Predicate
        List<Predicate> predicates = new ArrayList<>();
        //Department Filter
        if(department != null){
            predicates.add(
                    cb.equal(root.get("department"),department)
            );
        }
        //Salary filter
        if(salary != null){
            predicates.add(
                    cb.greaterThan(root.get("salary"),salary)
            );
        }

        //Step5: Apply WHERE Conditions
        query.where(
                predicates.toArray(new Predicate[0])
        );
        //Step6: Sorting
        Order order;
        //Descending order
        if(direction.equalsIgnoreCase("desc")){
            order = cb.desc(root.get(sortBy));
        }

        //Ascending
        else{
            order = cb.asc(root.get(sortBy));
        }
        query.orderBy(order);

        //Step7: Create Executable Query
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

        //Step8: Pagination
        //starting record
        int start = page*size;

        //OFFSET
        typedQuery.setFirstResult(start);

        //LIMIT
        typedQuery.setMaxResults(size);

        //Step9: Execute Query
        return typedQuery.getResultList();





    }
}
