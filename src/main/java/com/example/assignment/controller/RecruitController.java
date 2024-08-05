package com.example.assignment.controller;


import com.example.assignment.dto.CustomRecruitDTO;
import com.example.assignment.dto.RecruitDTO;
import com.example.assignment.dto.RecruitSummaryDTO;
import com.example.assignment.entity.Recruit;
import com.example.assignment.service.RecruitService;
import com.example.assignment.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @PostMapping("/upload")
    public ResponseEntity<RecruitDTO> createRecruit(@RequestBody Recruit recruit) {
        RecruitDTO createdRecruit = recruitService.saveRecruit(recruit);
        return ResponseEntity.ok(createdRecruit);
    }

    @PatchMapping("/modify/{num}")
    public ResponseEntity<?> updateRecruit(@PathVariable int num, @RequestBody RecruitDTO recruitDTO) {
        try {
            RecruitDTO updatedRecruit = recruitService.updateRecruit(num, recruitDTO);
            return ResponseEntity.ok(updatedRecruit);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/{num}")
    public ResponseEntity<String> deleteRecruit(@PathVariable int num) {
        try {
            String message = recruitService.deleteRecruit(num);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<RecruitSummaryDTO>> getAllRecruits() {
        List<RecruitSummaryDTO> recruits = recruitService.getAllRecruits();
        return ResponseEntity.ok(recruits);
    }

    @GetMapping("/search")
    @JsonView(Views.Summary.class)
    public ResponseEntity<List<Recruit>> searchRecruits(@RequestParam("search") String keyword) {
        List<Recruit> recruits = recruitService.searchRecruits(keyword);
        return ResponseEntity.ok(recruits);
    }

    @GetMapping("/detail/{num}")
    public ResponseEntity<Object> getCustomRecruitById(@PathVariable int num) {
        try {
            CustomRecruitDTO customRecruit = recruitService.getCustomRecruitById(num);
            return ResponseEntity.ok(customRecruit);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
