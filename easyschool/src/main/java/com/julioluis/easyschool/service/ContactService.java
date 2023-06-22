package com.julioluis.easyschool.service;


import com.julioluis.easyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
//@RequestScope
@SessionScope
public class ContactService {

    private int counter=0;

    public ContactService() {
        System.out.println("Contact initializing");
    }

    public boolean saveContactDetail(Contact contact) {
        log.info("Contact:: "+ contact);

        return true;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
