/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Zhao
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import model.Student;

public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public StudentDAO() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebJPAPU");
        em = emf.createEntityManager();
    }

    public void addStudent(Student student) {
         em.getTransaction().begin();
        try {
            em.persist(student);
            em.getTransaction().commit();           
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void editStudent(Student student) {
        em.getTransaction().begin();
        try {
            em.merge(student);            
            em.getTransaction().commit();   
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }    
    }

    public void deleteStudent(String id) {
        Student student = em.find(Student.class, id);
          em.getTransaction().begin();
        try {
            em.remove(student);
            em.getTransaction().commit();      
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Student getStudent(String id) {
        return em.find(Student.class, id);
    }

    public List getAllStudents() {       
        return em.createNamedQuery("Student.findAll").getResultList();
    }
}