/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_preparation_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jonas
 */
public class OrderFacade {
    
   static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Exam_preparation_JPA_jar_1.0-SNAPSHOTPU");
    
    public static void creatOrder(Orderr o){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            
        }finally{
            em.close();
            
        }
    }
    
    public static void addOrderToCustomer(Orderr o, Customer c){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            o.setCustomer(c);
            em.merge(o);
            em.getTransaction().commit();
            
        } finally{
            em.close();
        }
        
    }
    
    public static Orderr findOrder(Long id){
        EntityManager em = emf.createEntityManager();
        try{
            Orderr o;
            em.getTransaction().begin();
            o = em.find(Orderr.class,id);
            em.getTransaction().commit();
            return o;
        }finally{
      
            em.close();
        }
        
    }
    
    
    public static void createItemType(ItemType i){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        
    }
    
    public static void createOrderLine(OrderLine ol){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(ol);
            em.getTransaction().commit();
            
        } finally{
            em.close();
        }
        
    }
    
    
    public static void main(String[] args) {
      Customer customer = new Customer("Hans", "Hans@mail.com");
      Orderr order = new Orderr(customer);
      ItemType i = new ItemType("Bog", "Med sider", 10.10);
      OrderLine ol = new OrderLine(order, i, 5);
        createItemType(i);
        createOrderLine(ol);
    
    }
    
}
