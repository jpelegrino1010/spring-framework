package com.julioluis.easyschool.service;


import com.julioluis.easyschool.constants.EasySchoolContants;
import com.julioluis.easyschool.model.Contact;
import com.julioluis.easyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
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
       Contact contactSaved = contactRepository.save(contact);
        if(contactSaved.getId()>0) {
            isSaved = true;
        }
        return isSaved;
    }


    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findContactByStatus(EasySchoolContants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EasySchoolContants.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }


}
