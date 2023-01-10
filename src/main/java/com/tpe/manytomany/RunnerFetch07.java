package com.tpe.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Task 1: get data of dev whose project id=11
        Project project = session.get(Project.class,11L);
        project.getDevs().forEach(System.out::println);


        tx.commit();
        session.close();
        sf.close();


    }
}
