package com.example.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyId implements Serializable {
    private String userId;
    private int recruitNum;
}
