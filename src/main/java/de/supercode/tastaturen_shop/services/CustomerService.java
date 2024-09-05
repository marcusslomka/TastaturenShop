package de.supercode.tastaturen_shop.services;

import de.supercode.tastaturen_shop.entities.kunde.Customer;
import de.supercode.tastaturen_shop.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createNewCustomer(Customer customer){

        this.customerRepository.save(customer);
    }
    public Optional<Customer> getCustomer(long id){
        return this.customerRepository.findById(id);
    }
    public Customer updateCustomer(long id, Customer customer){
        Customer toUpdateCustomer = customerRepository.findById(id).orElse(null);
        if (customer == null) return null;
        toUpdateCustomer.setAddress(customer.getAddress());
        toUpdateCustomer.setEmail(customer.getEmail());
        toUpdateCustomer.setFirstName(customer.getFirstName());
        toUpdateCustomer.setLastName(customer.getLastName());
        return customerRepository.save(toUpdateCustomer);
    }
    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }

}
