package com.netcracker.facebook.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Created by nipa1116 on 6/12/2017.
 */

@Controller
@RequestMapping(value="VIEW")

public class FacebookAPIController {

    @RenderMapping
    public String viewHomePage(RenderRequest request, RenderResponse response){



        return "view";

    }
}
