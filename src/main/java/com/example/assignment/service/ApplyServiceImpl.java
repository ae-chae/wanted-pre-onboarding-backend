package com.example.assignment.service;

import com.example.assignment.dto.ApplyDTO;
import com.example.assignment.entity.Apply;
import com.example.assignment.repository.ApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    @Override
    public ApplyDTO saveApplication(ApplyDTO applyDTO) {
        Apply apply = new Apply();
        apply.setUserId(applyDTO.getUserId());
        apply.setRecruitNum(applyDTO.getRecruitNum());
        Apply savedApply = applyRepository.save(apply);
        return convertToDTO(savedApply);
    }

    private ApplyDTO convertToDTO(Apply apply) {
        return new ApplyDTO(apply.getUserId(), apply.getRecruitNum());
    }
}