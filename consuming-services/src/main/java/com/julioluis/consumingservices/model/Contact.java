package com.julioluis.consumingservices.model;

import lombok.Data;

@Data
public class Contact {
    private int id;
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;
    private String status;
}
