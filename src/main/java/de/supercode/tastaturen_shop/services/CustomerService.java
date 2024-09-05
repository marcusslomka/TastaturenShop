package de.supercode.tastaturen_shop.services;

import de.supercode.tastaturen_shop.entities.kunde.Customer;
import de.supercode.tastaturen_shop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createNewCustomer(Customer customer){
        this.customerRepository.save(customer);
    }
    public Customer getCustomer(long id){
        Customer customer = this.customerRepository.findById(id).orElse(null);
        if (customer == null) return null;
            else return customer;
    }
}
