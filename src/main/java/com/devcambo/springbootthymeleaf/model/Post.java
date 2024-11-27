package com.devcambo.springbootthymeleaf.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    private int postId;
    private String title;
    private String thumbnail;
    @Column(columnDefinition = "TEXT")
    private String content;

}
