package com.example.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "pw", nullable = false, length = 10)
    private String pw;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Apply> applies;
}

