package com.tpe.onetomany_bi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {

    public static void main(String[] args) {

        Company3 com1 = new Company3(11L,"Google");
        Company3 com2 = new Company3(22L,"Amazon");
        Company3 com3 = new Company3(33L,"Trendyol");

        Developer06 dev1 = new Developer06(1L,"Harry Potter","hp@gmail.com","backend",com1);
        Developer06 dev2 = new Developer06(2L,"Shrek","shrek@gmail.com","frontend",com1);
        Developer06 dev3 = new Developer06(3L,"Jack Sparrow","jack@gmail.com","mobile",com2);
        Developer06 dev4 = new Developer06(4L,"Richy Rich","richy@gmail.com","fullstack",com2);
        Developer06 dev5 = new Developer06(5L,"Gandalf","gandalf@gmail.com","backend",com3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(com1);
        session.save(com2);
        session.save(com3);

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
