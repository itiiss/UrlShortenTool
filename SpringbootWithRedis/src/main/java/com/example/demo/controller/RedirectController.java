package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import com.example.demo.service.shortUrlService;

@Controller
public class RedirectController {

    @Autowired private shortUrlService shortUrlService;

    @RequestMapping("/{name}")
    public void redirect(@PathVariable("name") String name, HttpServletResponse response) throws Exception {
        try {
            String result = shortUrlService.shortToLong(name);
            if( result == null) {
                response.sendError(404);
            } else {
                response.sendRedirect(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(503);
        }
    }
}
