package com.netcracker.controller;

/**
 * Created by pomu0116 on 6/1/2017.
 */

import com.netcracker.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class CustomerController {

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int custId) {
        Map<Integer, Customer> stub = createStub(custId);
        return new ResponseEntity<Customer>(stub.get(custId), HttpStatus.OK);
    }

    public Map<Integer,Customer> createStub (int cusId){

        Map<Integer, Customer> custData = new HashMap<Integer, Customer>();
        Customer customer = new Customer();
        customer.setId(1234);
        customer.setName("Shiva Karan");
        custData.put(1234,customer);
        return custData;
    }
}
