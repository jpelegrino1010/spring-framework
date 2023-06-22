package com.julioluis.paginateapp.repository;

import com.julioluis.paginateapp.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    @Query(value = "SELECT e FROM Employee e WHERE e.firstName=?1")
    Page<Employee> findAllByName(String name, Pageable pageable);
}
