package com.tpe.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Get all the data of dev id=1
        Developer03 dev1 = session.get(Developer03.class,1L);
        System.out.println(dev1);

        // Get all data of computer id=33
        Computer com1 = session.get(Computer.class,33L);
        System.out.println(com1);

        // Get dev data of computer id=22
        Computer com2 = session.get(Computer.class,22L);
        System.out.println(com2.getDeveloper());

        // get computer data of dev id=2
        Developer03 dev2 = session.get(Developer03.class,2L);
        System.out.println(dev2.getComputer());


        tx.commit();
        session.close();
        sf.close();

    }
}
