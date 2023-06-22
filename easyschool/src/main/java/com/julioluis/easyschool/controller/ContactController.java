package com.julioluis.easyschool.controller;


import com.julioluis.easyschool.model.Contact;
import com.julioluis.easyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ContactController {



    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String displayContact(Model model) {
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }

    @PostMapping("/saveMessage")
    public ModelAndView createContact(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        ModelAndView modelAndView=new ModelAndView("redirect:/contact");
        if (errors.hasErrors()) {
            log.error("Error on contact form "+ errors.toString());
            modelAndView=new ModelAndView("/contact.html");
            return modelAndView;
        }
        contactService.setCounter(contactService.getCounter()+1);
        log.info("You are submitting bean # "+ contactService.getCounter());
        contactService.saveContactDetail(contact);

        return modelAndView;
    }
}
