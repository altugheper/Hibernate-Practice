package com.tpe.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Task 1: get the data of dev's company of whose id=2
        Developer04 task1 = session.get(Developer04.class,2L);
        System.out.println(task1.getCompany());
        // we can get to company through dev, but not vice versa.

        System.out.println("******************************************");

        // Task 2: get all devs' names and the company names they work for
        String sqlQuery = "SELECT d.name,c.companyname FROM t_developer4 d INNER JOIN company c on d.company_id=c.id";
        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
        for (Object[] result:resultList){
            System.out.println(Arrays.toString(result));
        }

        System.out.println("******************************************");

        // Task 3: Get devs' names and branches who work for Google
        String sqlQuery2 = "SELECT d.name,d.branch FROM t_developer4 d WHERE company_id=11";
        List<Object[]> resultList2 = session.createSQLQuery(sqlQuery2).getResultList();
        for (Object[] r:resultList2){
            System.out.println(Arrays.toString(r));
        }

        tx.commit();
        session.close();
        sf.close();

    }
}
