package com.julioluis.easyschool.service;


import com.julioluis.easyschool.constants.EasySchoolContants;
import com.julioluis.easyschool.model.Person;
import com.julioluis.easyschool.model.Roles;
import com.julioluis.easyschool.repository.PersonRepository;
import com.julioluis.easyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EasySchoolContants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}