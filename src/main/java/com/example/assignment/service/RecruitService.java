package com.example.assignment.service;

import com.example.assignment.dto.RecruitDTO;
import com.example.assignment.dto.RecruitSummaryDTO;
import com.example.assignment.entity.Recruit;

import java.util.List;

public interface RecruitService {
    RecruitDTO saveRecruit(Recruit recruit);
    RecruitDTO updateRecruit(int num, RecruitDTO recruitDTO);
    String deleteRecruit(int num);
    List<RecruitSummaryDTO> getAllRecruits();
}
