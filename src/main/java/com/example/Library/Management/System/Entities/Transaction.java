package com.example.Library.Management.System.Entities;

import com.example.Library.Management.System.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;


    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private Date returnDate;

    private Integer fine;

    @CreationTimestamp
    private Date createdOn;


    @UpdateTimestamp
    private Date lastModifiedOn;


    //Connect FK  with Book Entity
    @ManyToOne
    @JoinColumn
    private Book book;


    @ManyToOne
    @JoinColumn
    private LibraryCard card;
}
