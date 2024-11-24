package com.devcambo.springbootthymeleaf.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Contact {
    private String name;
    @NotEmpty
    @Email
    private String email;
    private String subject;
    private String message;
}
