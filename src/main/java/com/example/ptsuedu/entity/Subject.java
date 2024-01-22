package com.example.ptsuedu.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Subject extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

}
