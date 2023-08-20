package com.julioluis.consumingservices.proxy;

import com.julioluis.consumingservices.config.ProjectConfiguration;
import com.julioluis.consumingservices.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@FeignClient(name = "contact",url = "http://localhost:8080/api/contact",
configuration = ProjectConfiguration.class)
public interface ContactProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/getMessageByStatus")
    @Headers(value = "Content-Type: application/json")
    List<Contact> getMessagesByStatus(@RequestParam("status") String status);
}
