package com.netcracker.controller;

import java.util.HashMap;
import java.util.Map;


import com.netcracker.model.Quote;
import com.netcracker.model.Contact;
import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class Quotecontroller {


	// GET Quote by Id
	@RequestMapping(value = "/quote/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Quote> getquote(@PathVariable("id") int quoteId) {
		Map<Integer, Quote> stub = createStub(quoteId);
		return new ResponseEntity<Quote>(stub.get(quoteId), HttpStatus.OK);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> createIt() {
		Random random = new Random();
         int randomInteger=0;
		for(int i =0; i<5; i++){
			 randomInteger = random.nextInt();
			System.out.println("Random Integer in Java: " + randomInteger);
		}
		return new ResponseEntity<String>("the quote is creted successfully and the Id for quote is  "+randomInteger, HttpStatus.OK);
	}


	public Map<Integer,Quote> createStub (int quoteId){

		Map<Integer, Quote> quotedata = new HashMap<Integer, Quote>();
		Quote quote = new Quote();
		Contact contact=new Contact();
		quote.setId(1111);
		quote.setName("First Quote");
		quote.setDescription("This is the quote without discount");
		quote.setMRC("$500");
		quote.setNRC("$10");

		quotedata.put(quoteId,quote);
		return quotedata;
	}
	 
   
}
