package com.tpe.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.management.Query;

public class RunnerFetch09 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Task 1: update dev name to Sezai Karakoc whose id=1
        Developer09 dev = session.get(Developer09.class,1L);
        dev.setName("Sezai Karakoc");
        session.update(dev);

        System.out.println("*********************************");

        // Task 2: Task 1 with HQL
        String hqlQuery = "UPDATE Developer09 d SET d.name='Sair Sezai Karakoc' WHERE d.id=1";
        int numRecord = session.createQuery(hqlQuery).executeUpdate();
        System.out.println("numRecords: " + numRecord);

        System.out.println("*********************************");

        // Task 3: update salary to 7850 whose salary is under 7000
        String hqlQuery2 = "UPDATE Developer09 d SET d.salary=7850 WHERE d.salary<=7000";
        int query = session.createQuery(hqlQuery2).executeUpdate();
        System.out.println("hqlQuery2: " + query);

        tx.commit();
        session.close();
        sf.close();

    }
}
