package com.devcambo.springbootthymeleaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "contacts")
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    private int contactId;
    private String name;
    @NotEmpty
    @Email
    private String email;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String message;

}
