package com.julioluis.easyschool.controller;


import com.julioluis.easyschool.model.Contact;
import com.julioluis.easyschool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {



    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String displayContact() {
        return "contact.html";
    }

    @PostMapping("/saveMessage")
    public ModelAndView createContact(Contact contact) {
        contactService.saveContactDetail(contact);

        return new ModelAndView("redirect:/contact");
    }
}
