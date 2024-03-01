package com.example.pstuedu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String icon;
    private String linkToResource;

    @ManyToOne
    private Lesson lesson;

}
