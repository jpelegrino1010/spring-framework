package com.julioluis.easyschool.repository;

import com.julioluis.easyschool.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday,String> {
}
