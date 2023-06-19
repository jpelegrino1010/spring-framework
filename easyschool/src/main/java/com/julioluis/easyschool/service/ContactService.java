package com.julioluis.easyschool.service;


import com.julioluis.easyschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log= LoggerFactory.getLogger(ContactService.class);

    public boolean saveContactDetail(Contact contact) {
        log.info("Contact:: "+ contact);
        return true;
    }
}
