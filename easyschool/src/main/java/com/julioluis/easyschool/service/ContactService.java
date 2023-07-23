package com.julioluis.easyschool.service;


import com.julioluis.easyschool.constants.EasySchoolContants;
import com.julioluis.easyschool.model.Contact;
import com.julioluis.easyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
//@RequestScope
@SessionScope
public class ContactService {

    @Autowired
   private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact initializing");
    }

    public boolean saveContactDetail(Contact contact) {
        boolean isSaved = false;

        contact.setStatus(EasySchoolContants.OPEN);
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EasySchoolContants.ANONYMOUS);

        int result = contactRepository.saveContactMsg(contact);
        if(result>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(EasySchoolContants.OPEN);
        return contactMsgs;
    }



}
