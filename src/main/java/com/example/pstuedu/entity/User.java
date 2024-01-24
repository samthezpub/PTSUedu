package com.example.pstuedu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "'user'")
public class User extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

//    На будущее
//    private String email;

}
