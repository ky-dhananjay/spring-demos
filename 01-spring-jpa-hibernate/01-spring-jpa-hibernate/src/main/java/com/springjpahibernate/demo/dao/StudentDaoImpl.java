package com.springjpahibernate.demo.dao;

import com.springjpahibernate.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{


    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query =
            entityManager.createQuery("from Student order by firstName",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> q =
            entityManager.createQuery(
                "from Student where lastName =:theLastName",
                Student.class);
        q.setParameter("theLastName",lastName);
        return q.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //check whether student already exist
        Student student = entityManager.find(Student.class, id);
        //delete the existing user
        if(student !=null)
            entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        Query q =
            entityManager.createQuery("delete from Student");
        return q.executeUpdate();
    }
}
