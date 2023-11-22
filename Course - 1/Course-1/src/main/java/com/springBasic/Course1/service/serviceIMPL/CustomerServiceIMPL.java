package com.springBasic.Course1.service.serviceIMPL;

import com.springBasic.Course1.repository.CustomerRepo;
import com.springBasic.Course1.dto.CustomerDTO;
import com.springBasic.Course1.dto.request.CustomerUpdateDTO;
import com.springBasic.Course1.entity.Customer;
import com.springBasic.Course1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    public CustomerRepo customerRepo;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : customerList){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );

            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );

        customerRepo.save(customer);
        return null;

    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())){

            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " is updated";
        }
        else{
            throw new RuntimeException("data not found");
        }



    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        if (customerRepo.existsById(customerId)){

            Customer customer = customerRepo.getReferenceById(customerId);

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );

            return customerDTO;

        }
        else{
            throw new RuntimeException("data not found");
        }

    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return customerId + " has deleted";
        }else{
            throw new RuntimeException("data not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeState) {
        List<Customer> customerList = customerRepo.findAllByActiveStateEquals(activeState);

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer : customerList){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );

            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }
}
