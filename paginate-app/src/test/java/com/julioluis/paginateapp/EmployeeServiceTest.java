package com.julioluis.paginateapp;

import com.julioluis.paginateapp.model.Employee;
import com.julioluis.paginateapp.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAllPagable() {
        Pageable pageable=PageRequest.of(0,1);
        Page<Employee> result=employeeRepository.findAll(pageable);

        System.out.println(result);

    }

    @Test
    public void testFindAllPagableAndSort() {
        Pageable pageable=PageRequest.of(0,3,Sort.by("firstName"));
        Page<Employee> result=employeeRepository.findAll(pageable);

        result.stream().forEach(e -> System.out.println(e.getFirstName()));
        System.out.println(result);

    }

    @Test
    public void testFindAllByName() {
        Pageable pageable=PageRequest.of(0,1);
        Page<Employee> result=employeeRepository.findAllByName("Pedro",pageable);

        System.out.println(result);
    }
}
