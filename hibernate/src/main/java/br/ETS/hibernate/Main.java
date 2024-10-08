package br.ETS.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Material material = new Material(new MaterialDTO("Caneta", "Só Canetas", 600));
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("almoxarifado");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.persist(material);


    }
}