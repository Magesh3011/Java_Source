package com.db.hiber.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Pojo pojo=new Pojo();
        pojo.setName("Kumar");
        pojo.setAge(26);
        pojo.setId(2);
        
        
        System.out.println(pojo.toString());
        
        Configuration config=new Configuration();
        config.addAnnotatedClass(com.db.hiber.test.Pojo.class);
        config.configure();
        
        SessionFactory SesFactory=config.buildSessionFactory();
        
        Session session=SesFactory.openSession();
        //Transaction required for update,insert and the deletion
        //Transaction transaction=session.beginTransaction();
        //transaction.commit();
        
        Transaction transaction=session.beginTransaction();
        
        session.persist(pojo);
        
        transaction.commit();
        
    }
}
