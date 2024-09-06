package de.supercode.tastaturen_shop.controllers;

import de.supercode.tastaturen_shop.entities.kunde.Customer;
import de.supercode.tastaturen_shop.services.CustomerService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/shop/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Map<String,String> handleValidationError(ConstraintViolationException exception){
//        Map<String,String> errorMap = new HashMap<>();
//        exception.getConstraintViolations()
//                .forEach( violation -> {
//                    String fieldName = violation.getPropertyPath().toString();
//                    String errorMessage = violation.getMessage();
//                });
//        return errorMap;
//    }
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String,String> handleValidationError(MethodArgumentNotValidException exception){
//        Map<String,String> errorMap = new HashMap<>();
//        exception.getBindingResult().getAllErrors().forEach(error ->{
//            String fieldName = ((FieldError)error).getField();
//            String message = error.getDefaultMessage();
//
//            errorMap.put(fieldName, message);
//        });
//
//        return errorMap;
//    }

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
