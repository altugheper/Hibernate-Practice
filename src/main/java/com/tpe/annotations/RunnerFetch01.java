package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Developer01 dev1 = new Developer01();
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Get the developer whose id is 1
        dev1 = session.get(Developer01.class,1);
        System.out.println(dev1.toString());

        // 1: Get all the data with SQL
        String sqlQuery = "SELECT * FROM t_developer01";
        List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
        System.out.println("---SQL---");
        for (Object[] r:resultList1){
            System.out.println(Arrays.toString(r));
        }

        // 2: Get all the data with HQL
        String hqlQuery = "FROM Developer01";
        List<Developer01> resultList2 = session.createQuery(hqlQuery).getResultList();
        System.out.println("---HQL---");
        for (Developer01 d:resultList2){
            System.out.println(d.toString());
        }

        // 3: Get the data where the name is Shrek with HQL
        String hqlQuery2 = "FROM Developer01 WHERE name='Shrek'";
        List<Developer01> resultList3 = session.createQuery(hqlQuery2).getResultList();
        System.out.println("---HQL---");
        for (Developer01 d:resultList3){
            System.out.println(d.toString());
        }

        // 4: Get the data where the email is "jack@gmail.com" with HQL
        String hqlQuery3 = "FROM Developer01 WHERE email='jack@gmail.com'";
        List<Developer01> resultList4 = session.createQuery(hqlQuery3).getResultList();
        System.out.println("---HQL---");
        for (Developer01 d:resultList4){
            System.out.println(d.toString());
        }

        // 5: Get the data where the branch is backend with HQL
        String hqlQuery4 = "FROM Developer01 WHERE branch='backend'";
        List<Developer01> resultList5 = session.createQuery(hqlQuery4).getResultList();
        System.out.println("---HQL---");
        for (Developer01 d:resultList5){
            System.out.println(d.toString());
        }

        tx.commit();
        session.close();
        sf.close();

    }
}
