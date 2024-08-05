package com.example.assignment.service;

import com.example.assignment.dto.CustomRecruitDTO;
import com.example.assignment.dto.RecruitDTO;
import com.example.assignment.dto.RecruitSummaryDTO;
import com.example.assignment.entity.Recruit;
import com.example.assignment.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitRepository recruitRepository;

    @Override
    public RecruitDTO saveRecruit(Recruit recruit) {
        Recruit savedRecruit = recruitRepository.save(recruit);
        return convertToDTO(savedRecruit);
    }

    public RecruitDTO updateRecruit(int num, RecruitDTO recruitDTO) {
        Optional<Recruit> optionalRecruit = recruitRepository.findById(num);
        if (optionalRecruit.isPresent()) {
            Recruit recruit = optionalRecruit.get();
            if (recruitDTO.getCompanyId() != null && !recruitDTO.getCompanyId().equals(recruit.getCompanyId())) {
                throw new IllegalArgumentException("회사 ID는 수정할 수 없습니다.");
            }
            if (recruitDTO.getPosition() != null) {
                recruit.setPosition(recruitDTO.getPosition());
            }
            if (recruitDTO.getReward() != null) {
                recruit.setReward(recruitDTO.getReward());
            }
            if (recruitDTO.getDetail() != null) {
                recruit.setDetail(recruitDTO.getDetail());
            }
            if (recruitDTO.getTech() != null) {
                recruit.setTech(recruitDTO.getTech());
            }
            if (recruitDTO.getDistrict() != null) {
                recruit.setDistrict(recruitDTO.getDistrict());
            }
            recruitRepository.save(recruit);
            return convertToDTO(recruit);
        } else {
            throw new RuntimeException(num + " 번 공고는 존재하지 않습니다.");
        }
    }

    @Override
    public String deleteRecruit(int num) {
        Optional<Recruit> optionalRecruit = recruitRepository.findById(num);
        if (optionalRecruit.isPresent()) {
            Recruit recruit = optionalRecruit.get();
            recruitRepository.delete(recruit);
            return num + " 번 공고가 삭제되었습니다.";
        } else {
            throw new RuntimeException(num + " 번 공고는 존재하지 않습니다.");
        }
    }

    @Override
    public List<RecruitSummaryDTO> getAllRecruits() {
        List<Recruit> recruits = recruitRepository.findAll();
        return recruits.stream()
                .map(this::convertToSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Recruit> searchRecruits(String keyword) {
        try {
            int num = Integer.parseInt(keyword);
            Long reward = Long.parseLong(keyword);
            return recruitRepository.findByNumOrCompanyIdContainingOrRewardOrTechContainingOrDistrictContainingOrPositionContaining(
                    num, keyword, reward, keyword, keyword, keyword);
        } catch (NumberFormatException e) {
            // If parsing fails, search only the text fields
            return recruitRepository.findByNumOrCompanyIdContainingOrRewardOrTechContainingOrDistrictContainingOrPositionContaining(
                    -1, keyword, -1L, keyword, keyword, keyword);
        }
    }

    public CustomRecruitDTO getCustomRecruitById(int num) {
        Optional<Recruit> optionalRecruit = recruitRepository.findById(num);
        if (optionalRecruit.isPresent()) {
            Recruit recruit = optionalRecruit.get();
            List<Integer> otherJobPostings = recruitRepository.findByCompanyId(recruit.getCompanyId())
                    .stream()
                    .filter(r -> r.getNum() != num)
                    .map(Recruit::getNum)
                    .collect(Collectors.toList());

            return new CustomRecruitDTO(
                    recruit.getNum(),
                    recruit.getCompany().getName(),
                    recruit.getPosition(),
                    recruit.getReward(),
                    recruit.getDetail(),
                    recruit.getTech(),
                    recruit.getDistrict(),
                    otherJobPostings
            );
        } else {
            throw new RuntimeException(num + " 번 공고는 존재하지 않습니다.");
        }
    }


    private RecruitSummaryDTO convertToSummaryDTO(Recruit recruit) {
        return new RecruitSummaryDTO(
                recruit.getNum(),
                recruit.getCompanyId(),
                recruit.getPosition(),
                recruit.getReward(),
                recruit.getTech(),
                recruit.getDistrict()
        );
    }

    private RecruitDTO convertToDTO(Recruit recruit) {
        return new RecruitDTO(
                recruit.getNum(),
                recruit.getCompanyId(),
                recruit.getPosition(),
                recruit.getReward(),
                recruit.getDetail(),
                recruit.getTech(),
                recruit.getDistrict()
        );
    }
}
