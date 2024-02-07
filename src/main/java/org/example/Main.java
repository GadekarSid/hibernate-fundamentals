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
            Post p = new Post();
            p.setTitle("Post 1");
            p.setContent("POst 1 content");
            Comment c1 = new Comment();
            c1.setPost(p);
            c1.setContent("Content comment 1");
            em.persist(c1);
            em.persist(p);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}