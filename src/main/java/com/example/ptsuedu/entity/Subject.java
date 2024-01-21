package com.example.ptsuedu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Subject {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

}
