package com.example.Library.Management.System.Entities;

import com.example.Library.Management.System.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="library_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private String nameOnCard;

    private Integer noOfBooksIssued;

    @OneToOne
    @JoinColumn
    private Student student;


    //Connecting to transactions
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();

}
