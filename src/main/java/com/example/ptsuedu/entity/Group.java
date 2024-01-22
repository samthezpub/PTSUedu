package com.example.ptsuedu.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="\"group\"")
public class Group extends Base {

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<User> users;
}
