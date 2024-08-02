package com.example.assignment.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecruitSummaryDTO {
    private int num;
    private String companyId;
    private String position;
    private Long reward;
    private String tech;
    private String district;
}