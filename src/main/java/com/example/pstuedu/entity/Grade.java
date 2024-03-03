package com.example.pstuedu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grade")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Homework homework;

    private Short mark;
}
