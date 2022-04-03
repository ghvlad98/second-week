package jpa.domain;

import utils.JPAUtils;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPATest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private EntityTransaction et;
    private Query query;

    public void init() {
        emf = JPAUtils.getEntityManagerFactory();
        em = emf.createEntityManager();
    }

    public void createTransaction() {
        this.init();
        et = em.getTransaction();
        et.begin();

        Family family;
        Person person;

        Query q = em.createQuery("select * from Person m");
    }

    public static void print() {
    }

    public static void main(String[] args) {

    }
}
