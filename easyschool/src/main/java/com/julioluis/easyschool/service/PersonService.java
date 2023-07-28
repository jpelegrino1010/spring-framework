package com.julioluis.easyschool.service;


import com.julioluis.easyschool.constants.EasySchoolContants;
import com.julioluis.easyschool.model.Address;
import com.julioluis.easyschool.model.Person;
import com.julioluis.easyschool.model.Profile;
import com.julioluis.easyschool.model.Roles;
import com.julioluis.easyschool.repository.PersonRepository;
import com.julioluis.easyschool.repository.RolesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EasySchoolContants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}