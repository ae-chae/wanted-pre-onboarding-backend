package com.example.assignment.controller;

import com.example.assignment.dto.ApplyDTO;
import com.example.assignment.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apply")
public class ApplyController {

    private final ApplyService applyService;

    @Autowired
    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @PostMapping
    public ResponseEntity<ApplyDTO> createApplication(@RequestBody ApplyDTO applyDTO) {
        ApplyDTO createdApply = applyService.saveApplication(applyDTO);
        return new ResponseEntity<>(createdApply, HttpStatus.CREATED);
    }
}
