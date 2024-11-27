package com.devcambo.springbootthymeleaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int categoryId;
    private String name;
    private String description;

    /**
     * Many-To-One relationship with User entity.
     * This field represents the User associated with the Category.
     * The relationship is lazy-loaded, meaning that the User is not fetched
     * from the database until it is actually needed.
     * The User is optional, meaning that a Category can exist without a User.
     */
    @ManyToOne(
            fetch = FetchType.LAZY, // Load the User entity lazily when the Category entity is loaded
            optional = true // The User is not required for the Category to exist
    )
    @JoinColumn(
            name = "user_id", // Name of the foreign key column in the categories table
            referencedColumnName = "userId", // Name of the primary key column in the users table
            nullable = true // The foreign key column is nullable, allowing for Categories without Users
    )
    private User user; // The associated User entity

}
