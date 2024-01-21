package com.example.ptsuedu.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "'user'")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
