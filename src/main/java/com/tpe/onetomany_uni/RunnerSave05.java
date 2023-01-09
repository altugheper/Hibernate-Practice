package com.tpe.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Company2 com1 = new Company2(11L,"Google");
        Company2 com2 = new Company2(22L,"Amazon");

        Developer05 dev1 = new Developer05(1L,"Harry Potter","hp@gmail.com","backend",com1);
        Developer05 dev2 = new Developer05(2L,"Shrek","shrek@gmail.com","frontend",com1);
        Developer05 dev3 = new Developer05(3L,"Jack Sparrow","jack@gmail.com","mobile",com2);
        Developer05 dev4 = new Developer05(4L,"Richy Rich","richy@gmail.com","fullstack",com2);
        Developer05 dev5 = new Developer05(5L,"Gandalf","gandalf@gmail.com","backend",com2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company2.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(com1);
        session.save(com2);

        session.save(dev1);
        session.save(dev2);
        session.save(dev3);
        session.save(dev4);
        session.save(dev5);

        tx.commit();
        session.close();
        sf.close();

    }
}
