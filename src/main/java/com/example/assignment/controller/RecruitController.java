package com.example.assignment.controller;


import com.example.assignment.entity.Recruit;
import com.example.assignment.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @PostMapping("/upload")
    public ResponseEntity<Recruit> createRecruit(@RequestBody Recruit recruit) {
        Recruit createdRecruit = recruitService.saveRecruit(recruit);
        return ResponseEntity.ok(createdRecruit);
    }

}
