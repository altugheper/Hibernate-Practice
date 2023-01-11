package com.tpe.idgeneration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerSave08 {

    public static void main(String[] args) {

        Developer08 dev1 = new Developer08("Harry Potter","hp@gmail.com","backend");
        Developer08 dev2 = new Developer08("Shrek","shrek@gmail.com","frontend");
        Developer08 dev3 = new Developer08("Jack Sparrow","jack@gmail.com","mobile");
        Developer08 dev4 = new Developer08("Richy Rich","richy@gmail.com","fullstack");
        Developer08 dev5 = new Developer08("Gandalf","gandalf@gmail.com","backend");

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

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
