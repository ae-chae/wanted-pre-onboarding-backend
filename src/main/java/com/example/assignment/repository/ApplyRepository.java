package com.example.assignment.repository;

import com.example.assignment.entity.Apply;
import com.example.assignment.entity.ApplyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, ApplyId> {

}
