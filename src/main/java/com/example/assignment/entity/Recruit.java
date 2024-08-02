package com.example.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.example.assignment.view.Views;
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
    @JsonView(Views.Summary.class)
    private int num;

    @Column(name = "company_id", nullable = false)
    @JsonView(Views.Summary.class)
    private String companyId;

    @Column(name = "position")
    @JsonView(Views.Summary.class)
    private String position;

    @Column(name = "reward")
    @JsonView(Views.Summary.class)
    private Long reward;

    @Column(name = "detail", columnDefinition = "TEXT")
    @JsonView(Views.Detailed.class)
    private String detail;

    @Column(name = "tech", length = 50)
    @JsonView(Views.Summary.class)
    private String tech;

    @Column(name = "district", length = 20)
    @JsonView(Views.Summary.class)
    private String district;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @JsonBackReference
    private Company company;

    @OneToMany(mappedBy = "recruit")
    @JsonIgnore
    private Set<Apply> applies;
}