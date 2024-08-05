package com.example.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecruitDTO {
    private int num;
    private String companyId;
    private String position;
    private Long reward;
    private String detail;
    private String tech;
    private String district;


    public RecruitDTO(int num, String position, Long reward, String detail, String tech, String district) {
        this.num = num;
        this.position = position;
        this.reward = reward;
        this.detail = detail;
        this.tech = tech;
        this.district = district;
    }
}