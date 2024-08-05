package com.example.assignment.repository;

import com.example.assignment.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {
    List<Recruit> findByNumOrCompanyIdContainingOrRewardOrTechContainingOrDistrictContainingOrPositionContaining(
            int num, String companyId, Long reward, String tech, String district, String position);
}
