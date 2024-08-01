package com.example.assignment.service;

import com.example.assignment.entity.Recruit;
import com.example.assignment.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitRepository recruitRepository;

    @Override
    public Recruit saveRecruit(Recruit recruit) {
        return recruitRepository.save(recruit);
    }
}
