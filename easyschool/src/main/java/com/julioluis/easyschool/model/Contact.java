package com.julioluis.easyschool.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Contact {

    @NotBlank(message = "Name must no be blank")
    private String name;
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;
    @Email(message = "Provide a valid email address")
    @NotBlank(message = "email must no be blank")
    private String email;
    private String subject;
    private String message;


}
