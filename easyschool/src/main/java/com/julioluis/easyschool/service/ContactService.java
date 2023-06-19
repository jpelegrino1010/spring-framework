package com.julioluis.easyschool.service;


import com.julioluis.easyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {

    public boolean saveContactDetail(Contact contact) {
        log.info("Contact:: "+ contact);
        return true;
    }
}
