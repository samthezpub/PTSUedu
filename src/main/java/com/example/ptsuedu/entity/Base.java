package com.example.ptsuedu.entity;

import com.example.ptsuedu.Enum.EntityStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private EntityStatusEnum status;

    private Date creationDate;
}
