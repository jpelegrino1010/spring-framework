package com.julioluis.easyschool.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "contact_id")
    private Integer id;
    @NotBlank(message = "Name must no be blank")
    private String name;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;
    @Email(message = "Provide a valid email address")
    @NotBlank(message = "email must no be blank")
    private String email;
    private String subject;
    private String message;
    private String status;



}
