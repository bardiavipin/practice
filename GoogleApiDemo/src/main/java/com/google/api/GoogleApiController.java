package com.google.api;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Created by shra1116 on 6/12/2017.
 */
@Controller("GoogleApiController")
@RequestMapping(value="VIEW")
public class GoogleApiController {


    private Log log = LogFactoryUtil.getLog(GoogleApiController.class.getName());

    @RenderMapping
    public String viewGoogleAPIHomePage(RenderRequest request, RenderResponse response){

        log.info("#############################Calling viewGoogleAPIHomePage##################################");

        return "view";

    }
}


