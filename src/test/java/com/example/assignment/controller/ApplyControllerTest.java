package com.example.assignment.controller;

import com.example.assignment.dto.ApplyDTO;
import com.example.assignment.service.ApplyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApplyController.class)class ApplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplyService applyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createApplication_success() throws Exception {
        ApplyDTO applyDTO = new ApplyDTO("user1", 1);
        when(applyService.saveApplication(any(ApplyDTO.class))).thenReturn(applyDTO);

        mockMvc.perform(post("/apply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(applyDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").value("user1"))
                .andExpect(jsonPath("$.recruitNum").value(1));
    }

    @Test
    void createApplication_conflict() throws Exception {
        ApplyDTO applyDTO = new ApplyDTO("user1", 1);
        when(applyService.saveApplication(any(ApplyDTO.class))).thenThrow(new RuntimeException("동일 공고 중복 지원"));

        mockMvc.perform(post("/apply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(applyDTO)))
                .andExpect(status().isConflict())
                .andExpect(content().string("동일 공고 중복 지원"));
    }
}