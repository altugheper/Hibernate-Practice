package com.tpe.onetomany_bi;


import com.tpe.onetomany_uni.Developer05;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Task 1: Get data of dev who work for Amazon
        String hqlQuery = "FROM Company3 c WHERE c.companyName='Amazon'";
        Company3 companyA = session.createQuery(hqlQuery, Company3.class).uniqueResult();
        companyA.getDevs().forEach(System.out::println);

        System.out.println("****************************************");

        // Task 2: get company data of Gandalf
        String hqlQuery2 = "FROM Developer07 d WHERE d.name='Gandalf'";
        Developer06 dev = session.createQuery(hqlQuery2, Developer06.class).uniqueResult();
        System.out.println(dev.getCompany());

        System.out.println("****************************************");

        // Delete - Orphan Removal - Cascade Type All
        // Task 3: Remove of company id = 22 and dev = 3
        Developer06 dev3 = session.get(Developer06.class,3L);
        Company3 company = session.get(Company3.class,22L);
        company.getDevs().remove(dev3);
        System.out.println(company.getDevs());

        // Task 4: Delete company_id=11
        Company3 company2 = session.get(Company3.class,11L);
        session.delete(company2);


        tx.commit();
        session.close();
        sf.close();

    }

}
