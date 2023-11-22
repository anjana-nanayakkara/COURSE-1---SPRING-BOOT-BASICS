package com.springBasic.Course1.service;

import com.springBasic.Course1.dto.CustomerDTO;
import com.springBasic.Course1.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerById(int customerId);

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveStatus(boolean status);
}
