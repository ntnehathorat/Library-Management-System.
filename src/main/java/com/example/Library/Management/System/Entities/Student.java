package com.example.Library.Management.System.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private Integer studentId;

    private String name;
    private int age;

    @Column(name = "contactNo", unique = true,nullable = false)
    private String mobNo;

    private String emailId;

    private String bloodGroup;

    @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL)
    private LibraryCard libraryCard;

}
