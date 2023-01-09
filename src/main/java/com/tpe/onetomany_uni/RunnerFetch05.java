package com.tpe.onetomany_uni;

import com.tpe.manytoone.Company;
import com.tpe.manytoone.Developer04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Task 1: get dev data who work for Amazon
        String hqlQuery = "FROM Company2 c WHERE c.companyname='Amazon'";
        Company2 company = session.createQuery(hqlQuery, Company2.class).uniqueResult();
        company.getDevs().forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();

    }
}
