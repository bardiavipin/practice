package com.netcracker.controller;

import com.netcracker.model.Catalog;
import com.netcracker.model.Contact;
import com.netcracker.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yopa0716 on 6/2/2017.
 */


@Controller
@RequestMapping("/api")
public class CatalogController {

    // GET catalog by ID
    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Catalog> getcalatog(@PathVariable("id") int catalogId) {
        Map<Integer, Catalog> stub = createStub(catalogId);
        return new ResponseEntity<Catalog>(stub.get(catalogId), HttpStatus.OK);
    }

    public Map<Integer,Catalog> createStub (int catalogId){

        Map<Integer, Catalog> catalogData = new HashMap<Integer, Catalog>();
        Catalog catalog = new Catalog();
       
        catalog.setId(2222);
        catalog.setName("Customer Catalog");
        catalog.setDescription("This is the Catalog for the customer");
       

        catalogData.put(catalogId,catalog);
        return catalogData;
    }

}
