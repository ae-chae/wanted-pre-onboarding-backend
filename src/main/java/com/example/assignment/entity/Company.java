package com.example.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "company")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company {

    @Id
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Column(name = "pw", nullable = false, length = 10)
    private String pw;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "country", nullable = false, length = 10)
    private String country;

    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private Set<Recruit> recruits;
}
