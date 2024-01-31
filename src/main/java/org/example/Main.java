package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Product;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManager em;
       // EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
            // Represents the context
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(),
                new HashMap());
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Product p = new Product();
            p.setId(2L);
            p.setName("Wine");
            em.persist(p); // Add to context. -> Not an insert query.
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}