package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Singleton;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import models.*;

@Singleton
public class DataAccess {
	
	private SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
    /* CRUD Method - CREATE an employee in the database */
	
    public Integer addEmployee(Employee employee){   
    
 	  Session session = factory.openSession();
       Transaction tx = null;
       Integer employeeID = null;
       try{
          tx = session.beginTransaction();
          employeeID = (Integer) session.save(employee); 
          tx.commit();
       }catch (HibernateException e) {
          if (tx!=null) tx.rollback();
          e.printStackTrace(); 
       }finally {
          session.close(); 
       }
       return employeeID;
    } 
    
    public Employee getEmployee(Integer EmployeeID){
    	
    	Employee employee = null;

 		try{
 			   factory = new Configuration().configure().buildSessionFactory();
 		}catch (Throwable ex) { 
 			   System.err.println("Failed to create sessionFactory object." + ex);
 			   throw new ExceptionInInitializerError(ex); 
 		}	   
       Session session = factory.openSession();
       Transaction tx = null;
       try{
          tx = session.beginTransaction();
          employee = 
                     (Employee)session.get(Employee.class, EmployeeID); 
       }catch (HibernateException e) {
          if (tx!=null) tx.rollback();
          e.printStackTrace(); 
       }finally {
          session.close(); 
       }
       return employee;
    }
    

	/* CRUD Method - READ all the employees */
	
	public List<Employee> listEmployees( ){

	   Session session = factory.openSession();
	   Transaction tx = null;
	   List<Employee> employees = new ArrayList<Employee>();
	   try{
	      tx = session.beginTransaction();
	      employees = session.createQuery("FROM Employee").list(); 
	      Iterator iterator = employees.iterator();
	      while( iterator.hasNext()) {
	         Employee employee = (Employee) iterator.next();
	     	 System.out.printf("Id: %s",employee.getId());
	         System.out.printf(" First Name: %s",employee.getFirstName()); 
	         System.out.printf(" Last Name: %s%n",employee.getLastName()); 
	      }
	     
	   }catch (HibernateException e) {
	      if (tx!=null) tx.rollback();
	      e.printStackTrace(); 
	   }finally {
	      session.close(); 
	   }
	   return employees;
	}
	
   /* CRUD Method - UPDATE salary for an employee */
   
   public void updateEmployee(Integer EmployeeID, Long pay ){

      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                    (Employee)session.get(Employee.class, EmployeeID); 
         if (employee instanceof Fulltime){
        	 Fulltime ft = (Fulltime) employee;
        	 ft.setSalary(pay);
        	 session.update(ft);
         } else if (employee instanceof Parttime){
        	 Parttime pt = (Parttime) employee;
        	 pt.setSalary(pay);
        	 session.update(pt);
         } else if (employee instanceof Intern) {
        	 Intern it = (Intern) employee;
        	 it.setWage(pay);
        	 session.update(it);
         } else if (employee instanceof Contracter) {
        	 Contracter ct = (Contracter) employee;
        	 ct.setWage(pay);
        	 session.update(ct);
         } else {
        	 session.update(employee);
         } 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

   /* CRUD Method - DELETE an employee */
   
   public void deleteEmployee(Integer EmployeeID){
 	   
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = 
                   (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee);    
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }

}
		    

