package de.supercode.tastaturen_shop.controllers;

import de.supercode.tastaturen_shop.entities.kunde.Customer;
import de.supercode.tastaturen_shop.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shop/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> createNewCustomer(@RequestBody Customer customer){
        customerService.createNewCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable long id){
        if (customerService.getCustomer(id)==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        else return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getCustomer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        customerService.updateCustomer(id,customer);
        if (customerService.updateCustomer(id,customer) == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        else return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
