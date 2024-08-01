package com.example.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "RECRUIT")
@Getter
@Setter
public class Recruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num", nullable = false)
    private int num;

    @Column(name = "company_id", nullable = false)
    private String companyId;

    @Column(name = "position")
    private String position;

    @Column(name = "reward")
    private Long reward;

    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;

    @Column(name = "tech", length = 50)
    private String tech;

    @Column(name = "district", length = 20)
    private String district;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @JsonBackReference
    private Company company;

    @OneToMany(mappedBy = "recruit")
    @JsonIgnore
    private Set<Apply> applies;
}
