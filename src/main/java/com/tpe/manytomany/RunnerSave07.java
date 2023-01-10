package com.tpe.manytomany;

import com.tpe.onetomany_bi.Company3;
import com.tpe.onetomany_bi.Developer06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class RunnerSave07 {

    public static void main(String[] args) {

        Project project1 = new Project(11L,"CarRentalApp");
        Project project2 = new Project(22L,"AtmApp");

        Developer07 dev1 = new Developer07(1L,"Harry Potter","hp@gmail.com","backend");
        Developer07 dev2 = new Developer07(2L,"Shrek","shrek@gmail.com","frontend");
        Developer07 dev3 = new Developer07(3L,"Jack Sparrow","jack@gmail.com","mobile");
        Developer07 dev4 = new Developer07(4L,"Richy Rich","richy@gmail.com","fullstack");
        Developer07 dev5 = new Developer07(5L,"Gandalf","gandalf@gmail.com","backend");

        Set<Developer07> devSet = new HashSet<>();
        devSet.add(dev1);
        devSet.add(dev2);
        project1.setDevs(devSet);

        Set<Developer07> devSet2 = new HashSet<>();
        devSet2.add(dev1);
        devSet2.add(dev2);
        project2.setDevs(devSet2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(project1);
        session.save(project2);


        tx.commit();
        session.close();
        sf.close();

    }

}
