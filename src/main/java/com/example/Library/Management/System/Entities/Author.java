package com.example.Library.Management.System.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Nullability;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Column(nullable = false)
    private String authorName;

    private int age;

    private double rating;

    //Author should also have the information of the books written
    @OneToMany(mappedBy = "author" ,cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

}
