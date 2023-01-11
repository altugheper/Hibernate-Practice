package com.tpe.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch9 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //------------------------CriteriaAPI--------------------------
        // Task 1: Get data of "Cemal"
        CriteriaBuilder cbuilder = session.getCriteriaBuilder();
        CriteriaQuery<Developer09> cq = cbuilder.createQuery(Developer09.class);
        Root<Developer09> root = cq.from(Developer09.class);

        cq.select(root).where(cbuilder.equal(root.get("name"),"Cemal"));
        List<Developer09> result = session.createQuery(cq).getResultList();
        result.forEach(System.out::println);

        System.out.println("*************************************");

        // Task 2: Get data of "Erdem" and whose salary is more than 9000
        Predicate pred1 = cbuilder.equal(root.get("name"),"Erdem");
        Predicate pred2 = cbuilder.equal(root.get("salary"),"9000");
        Predicate predOr = cbuilder.or(pred1,pred2);
        cq.select(root).where(predOr);
        List<Developer09> result2 = session.createQuery(cq).getResultList();
        result2.forEach(System.out::println);

        System.out.println("*************************************");

        // Task 3: get data of dev whose salary is 8000
        Predicate pred3 = cbuilder.equal(root.get("salary"),"8000");
        Predicate pred123 = cbuilder.or(pred3);
        cq.select(root).where(pred123);
        List<Developer09> result3 = session.createQuery(cq).getResultList();
        result3.forEach(System.out::println);

        System.out.println("*************************************");

        // Task 4: get data of dev whose salary is more than 8000
        Predicate pred4 = cbuilder.greaterThan(root.get("salary"),"8000");
        Predicate pred223 = cbuilder.or(pred4);
        cq.select(root).where(pred223);
        List<Developer09> result4 = session.createQuery(cq).getResultList();
        result4.forEach(System.out::println);





        tx.commit();
        session.close();
        sf.close();

    }
}
