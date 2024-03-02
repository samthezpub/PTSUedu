package com.example.pstuedu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Lesson lesson;

    @Column(name = "text")
    private String text;

    // TODO editor text
}
