package com.tpe.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // 1: Get all data of the developer id=1
        Developer02 dev1 = session.get(Developer02.class,1L);
        System.out.println("**********TASK 1**********");
        System.out.println(dev1.toString());

        // 2: Get only education data of the dev id=1
        Developer02 dev2 = session.get(Developer02.class,1L);
        System.out.println("**********TASK 2**********");
        System.out.println(dev2.getEducation());




        tx.commit();
        session.close();
        sf.close();

    }
}
