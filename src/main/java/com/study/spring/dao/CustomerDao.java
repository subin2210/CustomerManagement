package com.study.spring.dao;

import com.study.spring.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int id);

    public void deleteCustomer(int id);
}
