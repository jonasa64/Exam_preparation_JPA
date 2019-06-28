/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_preparation_jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jonas
 */
public class CustomerFacadeImpl {
    
    private static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("com.mycompany_Exam_preparation_JPA_jar_1.0-SNAPSHOTPU");
    
    

   
    public static void creatCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            
        } finally{
            em.close();
        }
    }


    public static Customer findCustomer(Long id) {
       EntityManager em = emf.createEntityManager();
          Customer c = new Customer(); 
       try{
           em.getTransaction().begin();
            c = em.find(Customer.class, id);
            c.getId();
            c.getEmail();
            c.getName();
            em.getTransaction().commit();
              return c;
           
       }finally{
           em.close();
       }
     
    }

    
    public static List<Customer> findAllCustomer() {
      List<Customer> c = null;
      EntityManager em = emf.createEntityManager();
      try {
          em.getTransaction().begin();
          c = em.createQuery("Select c  from Customer c").getResultList();
           em.getTransaction().commit();
           return c;
          
      } finally{
          em.close();
      }
     
    }
    
    
    public static void main(String[] args) {

        
    }
    
}
