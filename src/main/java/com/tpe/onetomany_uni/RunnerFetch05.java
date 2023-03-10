package com.tpe.onetomany_uni;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company2.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Task 1: get dev data who work for Amazon
        String hqlQuery = "FROM Company2 c WHERE c.companyName='Amazon'";
        Company2 company = session.createQuery(hqlQuery, Company2.class).uniqueResult();
        company.getDevs().forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();

    }
}
