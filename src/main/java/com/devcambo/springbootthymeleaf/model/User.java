package com.devcambo.springbootthymeleaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int userId;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    /**
     * One-to-One relationship with Role entity.
     * This means each User is associated with one Role.
     */
    @OneToOne(
            fetch = FetchType.EAGER, // Load the Role entity eagerly when the User entity is loaded
            cascade = CascadeType.PERSIST, // Persist the Role entity when the User entity is persisted
            targetEntity = Role.class // Specify the target entity class
    )
    @JoinColumn(
            name = "role_id", // Name of the foreign key column in the users table
            referencedColumnName = "roleId", // Name of the primary key column in the roles table
            nullable = false // The foreign key column is not nullable
    )
    private Role role; // The associated Role entity

    /**
     * One-To-Many relationship with Category entity.
     * This field represents the set of categories associated with the user.
     * The relationship is lazy-loaded, meaning that the categories are not fetched
     * from the database until they are actually needed.
     * When a new user is persisted, all associated categories are also persisted.
     */
    @OneToMany(
            mappedBy = "user", // The field in Category that owns the relationship
            fetch = FetchType.LAZY, // Load categories only when needed
            cascade = CascadeType.PERSIST, // Persist categories when user is persisted
            targetEntity = Category.class // The type of entity in the relationship
    )
    private Set<Category> categories;

}
