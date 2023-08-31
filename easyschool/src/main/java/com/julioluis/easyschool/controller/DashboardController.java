package com.julioluis.easyschool.controller;

import com.julioluis.easyschool.model.Person;
import com.julioluis.easyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @Value("${easyschool.pageSize}")
    private int defaultPageNumber;

    @Value("${easyschool.contact.message}")
    private String message;

    @Autowired
    private Environment environment;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model,Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        session.setAttribute("loggedInPerson", person);
        logProperties();
        return "dashboard.html";
    }

    private void logProperties() {
        log.error("Error unexpected");
        log.error("Default pagination page "+ defaultPageNumber);
        log.error(message);

        log.error("default page size using environment "+ environment.getProperty("easyschool.pageSize"));
        log.error("Success message from environment "+ environment.getProperty("easyschool.contact.message"));
    }

}