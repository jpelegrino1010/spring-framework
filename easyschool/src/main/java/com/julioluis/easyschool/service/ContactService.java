package com.julioluis.easyschool.service;


import com.julioluis.easyschool.config.EasySchoolProps;
import com.julioluis.easyschool.constants.EasySchoolContants;
import com.julioluis.easyschool.model.Contact;
import com.julioluis.easyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@SessionScope
public class ContactService {

    @Autowired
   private ContactRepository contactRepository;
    @Autowired
    private EasySchoolProps easySchoolProps;

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

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){

        int pageSize=easySchoolProps.getPageSize();
        if(Objects.nonNull(easySchoolProps.getContact().get("pageSize"))){
            pageSize=Integer.valueOf(easySchoolProps.getContact().get("pageSize"));
        }

        Pageable page= PageRequest.of(pageNum-1,pageSize, sortDir.equals("asc")?Sort.by(sortField).ascending()
                :Sort.by(sortField).descending());
        Page<Contact> contactPage = contactRepository.findOpenMsgs(EasySchoolContants.OPEN,page);
        return contactPage;
    }


    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;

        int row=contactRepository.updateStatus(EasySchoolContants.CLOSE,contactId);
        if(row>0) {
            isUpdated = true;
        }
        return isUpdated;
    }


}
