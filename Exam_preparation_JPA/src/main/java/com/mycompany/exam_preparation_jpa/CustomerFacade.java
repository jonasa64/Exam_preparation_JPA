/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam_preparation_jpa;

import java.util.List;

/**
 *
 * @author Jonas
 */
public interface CustomerFacade {
    
    public void  creatCustomer(Customer c);
    public Customer findCustomer(Long id);
    public List<Customer> findAllCustomer();
    
}
