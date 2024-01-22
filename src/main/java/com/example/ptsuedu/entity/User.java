package com.example.ptsuedu.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="\"user\"")
public class User extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
