package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest {
   public static void main(String[] args) {
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("try");
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       
//       List<Employee> result = entityManager.createNamedQuery("Employee.findAll").getResultList();
       List<Employee> result = entityManager.createQuery("select e from Employee e").getResultList();
       for (Employee user : result) {
           System.out.println(user.getEmployeeNumber());
       }
       
       entityManager.getTransaction().commit();
       entityManager.close();

   }
}
