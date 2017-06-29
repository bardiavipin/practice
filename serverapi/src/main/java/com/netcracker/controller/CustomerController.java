package com.netcracker.controller;

/**
 * Created by pomu0116 on 6/1/2017.
 */

import com.netcracker.model.Contact;
import com.netcracker.model.ContactMethod;
import com.netcracker.model.Customer;
import com.netcracker.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;
import java.util.*;

@Controller
@RequestMapping("/api")
public class CustomerController {

    // GET Customer by ID
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int custId) {
        Map<Integer, Customer> stub = createStub(custId);
        return new ResponseEntity<Customer>(stub.get(custId), HttpStatus.OK);
    }

    public Map<Integer,Customer> createStub (int cusId){

        Map<Integer, Customer> custData = new HashMap<Integer, Customer>();
        Customer
                customer = new Customer();
        customer.setId(1234);
        customer.setName("Shiva Karan");
        customer.setType("Resideniatal Customer");
        customer.setEmail("shiav@gmail.com");
        customer.setAccountNumber(1233333);



        Contact contact = new Contact();
        contact.setContactId(56851);
        contact.setContactName("Shiv");


        ContactMethod contactMethod = new ContactMethod();
        List<String> type=new ArrayList<String>();
         type.add("PhoneNumber");
        contactMethod.setContactMethodType(type);
        contact.setContactMethod(contactMethod);

        Location state=new Location();
        List<String> stateName=new ArrayList<String>();
        stateName.add("Madhe Pradesh");
        state.setState(stateName);



         customer.setContact(contact);
         customer.setLocation(state);
         custData.put(1234,customer);
         return custData;
    }
}
