package com.example.demo.service;

import com.example.demo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;

    //Method to fetch employees from database
    public List<Employee> getEmployee(){
        //Step1: get Criteria Builder(used to build query parts)
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        //Step2: create Query Object (creates a query for Employee entity)
        //this query will return Employee objects
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);

        //Step3: Define Table
        //Root represents Table/entity
        Root<Employee> root = query.from(Employee.class);

        //Step 4: Add WHERE Conditions
        /* SQL Equivalent:
            WHERE department = 'IT' AND salary >60000
         */
        query.where(
                cb.and(cb.equal(root.get("department"),"IT"),
                        cb.greaterThan(root.get("salary"),60000))

                );
        //Step 5: Convert Into Executable Query
        //entityManager.createQuery(query)  - converts CriteriaQuery into executable query
        //TypedQuery<Employee> means
        //query will return Employee objects
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

        //Step 6: Execute Query
        //getResultList() executes query and returns all matching records
        return typedQuery.getResultList();

    }
}
