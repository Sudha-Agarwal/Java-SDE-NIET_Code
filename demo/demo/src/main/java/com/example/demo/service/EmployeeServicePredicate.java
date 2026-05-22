package com.example.demo.service;

import com.example.demo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServicePredicate {
    @PersistenceContext
    private EntityManager entityManager;

    //Dynamic search method
    public List<Employee> searchEmployees(String department, Double salary){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        //create a Predicate List
        //This list will store conditions dynamically
        List<Predicate> predicates = new ArrayList<>();

        if(department != null){
            predicates.add(
                    cb.like(root.get("department"),department)
            );
        }
        if(salary != null){
            predicates.add(
                    cb.greaterThan(root.get("salary"),salary)
            );
        }

        //Apply all conditions
        //Convert List<Predicate> into Predicate[]
        query.where(predicates.toArray(new Predicate[0]));

        //Execute Query
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();


    }
}


//localhost:8081/employees?department=IT&salary=60000