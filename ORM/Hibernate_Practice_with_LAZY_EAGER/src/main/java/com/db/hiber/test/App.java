package com.db.hiber.test;

import java.util.ArrayList;
import java.util.List;

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
       //------------------OneToMany-----------  
        
        
		  Engine engine=new Engine(); 
		  engine.setEnginePower("1400 CC");
		  engine.setId(101);
		  
		  
		  Car car=new Car(); 
		  car.setCarModel("Audi Q3"); 
		  car.setId(1);
		  
		  engine.getCar().add(car);
		  car.getEngine_list().add(engine);
		  
		  
		  
		  
        //------------------OneToMany- end-----------  
        
        SessionFactory  sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        
        Session session=sessionFactory.openSession();
   
		
		 // Transaction transaction=session.beginTransaction();
	
        
		 Car res= session.get(Car.class,1);
		 
			System.out.println(res.toString()  + " : "+res.getEngine_list() );
		  
		 // transaction.commit();
		 
       
    }
}
