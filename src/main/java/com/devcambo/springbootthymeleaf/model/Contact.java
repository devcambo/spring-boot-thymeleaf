package com.devcambo.springbootthymeleaf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int contactId;
    private String name;
    @NotEmpty
    @Email
    private String email;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String message;

}
