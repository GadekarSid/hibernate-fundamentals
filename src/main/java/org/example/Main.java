package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;
import org.example.entities.Product;
import org.example.entities.Student;
import org.example.entities.keys.ProductKey;
import org.example.entities.keys.StudentKey;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManager em;
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            // Represents the context
        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(),
                props);
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
//            Product p1 = new Product();
//            p1.setCode("abc");
//            p1.setNumber(10);
//            p1.setColor("Red");
//            em.persist(p1);
            StudentKey sk = new StudentKey();
            sk.setCode("11241");
            sk.setNumber(1151);
//            Student student = new Student();
//            student.setId(sk);
//            student.setName("Siddhu");
//            em.persist(student);
            Student s = em.find(Student.class,sk);
            System.out.println(s);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}