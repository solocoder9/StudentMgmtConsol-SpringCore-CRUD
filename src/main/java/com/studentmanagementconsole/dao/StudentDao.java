package com.studentmanagementconsole.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentmanagementconsole.entities.Student;

@Repository
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    // Save student
    @Transactional
    public int insert(Student student) {
        Session session = sessionFactory.getCurrentSession();
        return (int) session.save(student);
    }

    // Get single student by ID
    @Transactional(readOnly = true)
    public Student getStudent(int studentId) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Student.class, studentId);
    }

    // Get multiple students
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student", Student.class).list();
    }

    // Update student
    @Transactional
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    // Delete student by ID
    @Transactional
    public void deleteStudent(int studentId) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        if (student != null) {
            session.delete(student);
        }
    }
}
