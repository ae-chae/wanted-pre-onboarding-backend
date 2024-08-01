package com.example.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "APPLY")
@IdClass(ApplyId.class)
@Getter
@Setter
public class Apply {

    @Id
    @Column(name = "user_id", nullable = false, length = 10)
    private String userId;

    @Id
    @Column(name = "recruit_num", nullable = false)
    private int recruitNum;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "recruit_num", insertable = false, updatable = false)
    private Recruit recruit;
}
