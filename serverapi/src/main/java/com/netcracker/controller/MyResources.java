package com.netcracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pomu0116 on 6/1/2017.
 */
@Controller
@RequestMapping("/api")
public class MyResources {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> getIt() {
        return new ResponseEntity<String>("Got it", HttpStatus.OK);
    }

}
