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
        
		/*
		 * Pojo pojo=new Pojo(); pojo.setName("Singari"); pojo.setAge(23); //
		 * pojo.setId(5); pojo.setMobNum(121);
		 * 
		 * 
		 * System.out.println(pojo.toString());
		 */
        Engine engine=new Engine();
        engine.setEnginePower("1400 CC");
        engine.setId(104);
        
        Car car=new Car();
        car.setCarModel("Audi Q3");
        car.setId(4);
        car.setEngine(engine);
        
        
		/*
		 * Configuration config=new Configuration();
		 * config.addAnnotatedClass(com.db.hiber.test.Pojo.class); config.configure();
		 */
        
        SessionFactory  sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        
        Session session=sessionFactory.openSession();
        
        
        //Transaction required for update,insert and the deletion
        //Transaction transaction=session.beginTransaction();
        //transaction.commit();
        
        
        //-----------insert or create------------
		
		  Transaction transaction=session.beginTransaction();
		  
		  session.persist(car);
		  
		  transaction.commit();
		 
        //------------------insert or create- end-----------  
        //-----------fetch------------
		  
		 // session.get(Pojo.class,1);
		 
        //------------------fetch- end-----------  
        //-----------update------------
		  
		/*
		 * Transaction transaction=session.beginTransaction();
		 * 
		 * //merge will check the primary key row is there or not, if not it will create
		 * if there it will update the value session.merge(pojo);
		 * 
		 * transaction.commit();
		 */
		 
        //------------------update- end-----------  
        
      //-----------delete------------
        
		/*
		 * Transaction transaction=session.beginTransaction();
		 * 
		 * Pojo pojoD=session.find(Pojo.class,2);
		 * 
		 * session.remove(pojoD);
		 * 
		 * transaction.commit();
		 */
      //------------------delete- end-----------  
    }
}
