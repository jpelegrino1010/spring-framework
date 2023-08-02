package com.julioluis.easyschool.controller;


import com.julioluis.easyschool.model.Contact;
import com.julioluis.easyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

        contactService.saveContactDetail(contact);

        return modelAndView;
    }

    @RequestMapping("/displayMessages/page/{pageNum}")
    public ModelAndView displayMessages(Model model,
                                        @PathVariable(name = "pageNum") int pageNum,@RequestParam("sortField") String sortField,
                                        @RequestParam("sortDir") String sortDir) {
        Page<Contact> msgPage = contactService.findMsgsWithOpenStatus(pageNum,sortField,sortDir);
        List<Contact> contactMsgs = msgPage.getContent();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", msgPage.getTotalPages());
        model.addAttribute("totalMsgs", msgPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }


    @GetMapping(value = "/closeMsg")
    public String closeMsg(@RequestParam int id) {
        contactService.updateMsgStatus(id);
        return "redirect:/displayMessages/page/1?sortField=name&sortDir=desc";
    }

}
