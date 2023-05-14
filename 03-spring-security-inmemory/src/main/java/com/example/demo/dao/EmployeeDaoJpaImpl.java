package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> q = entityManager.createQuery("from Employee", Employee.class);
        return q.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        TypedQuery<Employee> q = entityManager.createQuery("from Employee where id=:employeeId", Employee.class);
        q.setParameter("employeeId", id);
        return q.getSingleResult();
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
       Employee employee =
           entityManager.find(Employee.class,id);
       entityManager.remove(employee);
    }
}
