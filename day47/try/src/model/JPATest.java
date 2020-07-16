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
       
       // Create
       Employee e = new Employee();
       e.setEmployeeNumber(1801);
       e.setEmail("sean@google.com");
       e.setFirstName("Sean");
       e.setLastName("Chen");
       e.setExtension("oxooox1");
       e.setJobTitle("VP2");
       e.setOfficeCode("1");
       entityManager.persist(e);
       
       // Need to find first before update & delete
       // Update
       Employee e2 = entityManager.find(Employee.class, 1625);
       e2.setJobTitle("Marketing Manager");
       entityManager.persist(e2);
       
       // Delete
       Employee e3 = entityManager.find(Employee.class, 1801);
       entityManager.remove(e3);
       
       entityManager.getTransaction().commit();
       entityManager.close();

   }
}
