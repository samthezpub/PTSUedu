package com.example.ptsuedu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Post {

    @Id
    private Long id;

}
