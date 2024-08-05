package com.example.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomRecruitDTO {
    private int id;
    private String companyName;
    private String position;
    private Long reward;
    private String details;
    private String tech;
    private String district;
    private List<Integer> otherJobPostings;
}