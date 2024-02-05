package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;
import org.example.entities.Product;
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
            Employee e1 = em.getReference(Employee.class,1);
            System.out.println(e1);
            e1.setName("Daniel");
            em.refresh(e1);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}