package com.springBasic.Course1.controller;

import com.springBasic.Course1.dto.CustomerDTO;
import com.springBasic.Course1.dto.request.CustomerUpdateDTO;
import com.springBasic.Course1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    public CustomerService customerService;
    @PostMapping
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){

        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        customerService.updateCustomer(customerUpdateDTO);
        return "updated";
    }

    @GetMapping(
            value = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam (value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);

        return customerDTO;
    }

    @GetMapping(value = "get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;

    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return  deleted;
    }

    @GetMapping(value = "get-all-customers-by-active-status/{status}")
    public List<CustomerDTO> getAllCustomers(@PathVariable(value = "status") boolean status){
        List<CustomerDTO> customersByStatus = customerService.getAllCustomersByActiveStatus(status);
        return customersByStatus;

    }

}
