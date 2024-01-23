package com.example.pstuedu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "\"group\"")
public class Group extends Base{
    private String name;

    @ManyToMany
    private List<User> users;
}
