package com.example.ptsuedu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private Subject subjects;

}
