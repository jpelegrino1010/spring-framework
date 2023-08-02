package com.julioluis.easyschool.repository;

import com.julioluis.easyschool.model.Contact;
import com.julioluis.easyschool.rommappers.ContactRowMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

List<Contact> findContactByStatus(String status);
Page<Contact> findContactByStatus(String status, Pageable pageable);

@Transactional
@Modifying
@Query(value = "UPDATE Contact c set c.status=?1 where c.id=?2")
int updateStatus(String status,Integer contactId);
}
