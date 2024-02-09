package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.*;
import org.example.entities.keys.ProductKey;
import org.example.entities.keys.StudentKey;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManager em;
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            // Represents the context
        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","create");
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(),
                props);
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Book book = new Book();
            book.setAuthor("Hiten");
            book.setId(1L);
            em.persist(book);
            ElectronicDevice device = new ElectronicDevice();
            device.setVoltage("10w");
            device.setId(2L);
            em.persist(device);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}