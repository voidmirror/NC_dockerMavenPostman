package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "contact")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
}
