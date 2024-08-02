package com.example.assignment.service;

import com.example.assignment.dto.RecruitDTO;
import com.example.assignment.entity.Recruit;

public interface RecruitService {
    RecruitDTO saveRecruit(Recruit recruit);
    RecruitDTO updateRecruit(int num, RecruitDTO recruitDTO);
    String deleteRecruit(int num);

}
