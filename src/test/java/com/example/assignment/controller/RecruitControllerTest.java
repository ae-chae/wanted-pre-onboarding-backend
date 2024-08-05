package com.example.assignment.controller;

import com.example.assignment.dto.CustomRecruitDTO;
import com.example.assignment.dto.RecruitDTO;
import com.example.assignment.dto.RecruitSummaryDTO;
import com.example.assignment.entity.Recruit;
import com.example.assignment.service.RecruitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecruitController.class)
class RecruitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecruitService recruitService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createRecruit_success() throws Exception {
        RecruitDTO recruitDTO = new RecruitDTO();
        recruitDTO.setCompanyId("id2");
        recruitDTO.setPosition("Developer");
        recruitDTO.setReward(3000000L);
        recruitDTO.setDetail("프론트엔드 개발자 모집");
        recruitDTO.setTech("React, Vue");
        recruitDTO.setDistrict("성남시");

        when(recruitService.saveRecruit(any(Recruit.class))).thenReturn(recruitDTO);

        mockMvc.perform(post("/recruit/upload")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recruitDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyId").value(recruitDTO.getCompanyId()))
                .andExpect(jsonPath("$.position").value(recruitDTO.getPosition()))
                .andExpect(jsonPath("$.reward").value(recruitDTO.getReward()))
                .andExpect(jsonPath("$.detail").value(recruitDTO.getDetail()))
                .andExpect(jsonPath("$.tech").value(recruitDTO.getTech()))
                .andExpect(jsonPath("$.district").value(recruitDTO.getDistrict()));
    }

    @Test
    void updateRecruit_success() throws Exception {
        RecruitDTO recruitDTO = new RecruitDTO();
        recruitDTO.setCompanyId("id2");
        recruitDTO.setPosition("Developer");
        recruitDTO.setReward(3000000L);
        recruitDTO.setDetail("프론트엔드 개발자 모집");
        recruitDTO.setTech("React, Vue");
        recruitDTO.setDistrict("성남시");

        when(recruitService.updateRecruit(anyInt(), any(RecruitDTO.class))).thenReturn(recruitDTO);

        mockMvc.perform(patch("/recruit/modify/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recruitDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyId").value(recruitDTO.getCompanyId()))
                .andExpect(jsonPath("$.position").value(recruitDTO.getPosition()))
                .andExpect(jsonPath("$.reward").value(recruitDTO.getReward()))
                .andExpect(jsonPath("$.detail").value(recruitDTO.getDetail()))
                .andExpect(jsonPath("$.tech").value(recruitDTO.getTech()))
                .andExpect(jsonPath("$.district").value(recruitDTO.getDistrict()));
    }

    @Test
    void updateRecruit_notFound() throws Exception {
        RecruitDTO recruitDTO = new RecruitDTO();
//        recruitDTO.setCompanyId("id2");
//        recruitDTO.setPosition("Developer");
//        recruitDTO.setReward(3000000L);
//        recruitDTO.setDetail("프론트엔드 개발자 모집");
//        recruitDTO.setTech("React, Vue");
//        recruitDTO.setDistrict("성남시");

        when(recruitService.updateRecruit(anyInt(), any(RecruitDTO.class))).thenThrow(new RuntimeException("수정 - 공고 번호 찾을 수 없음"));

        mockMvc.perform(patch("/recruit/modify/100")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recruitDTO)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("수정 - 공고 번호 찾을 수 없음"));
    }

    @Test
    void deleteRecruit_success() throws Exception {
        when(recruitService.deleteRecruit(anyInt())).thenReturn("공고 삭제 완료");

        mockMvc.perform(delete("/recruit/remove/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("공고 삭제 완료"));
    }

    @Test
    void deleteRecruit_notFound() throws Exception {
        when(recruitService.deleteRecruit(anyInt())).thenThrow(new RuntimeException("삭제 - 공고 번호 찾을 수 없음"));

        mockMvc.perform(delete("/recruit/remove/100"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("삭제 - 공고 번호 찾을 수 없음"));
    }

    @Test
    void getAllRecruits_success() throws Exception {
        RecruitSummaryDTO recruitSummaryDTO = new RecruitSummaryDTO();
        recruitSummaryDTO.setCompanyId("id2");
        recruitSummaryDTO.setPosition("Developer");
        recruitSummaryDTO.setReward(3000000L);
        recruitSummaryDTO.setTech("React, Vue");
        recruitSummaryDTO.setDistrict("성남시");

        List<RecruitSummaryDTO> recruitList = Arrays.asList(recruitSummaryDTO);
        when(recruitService.getAllRecruits()).thenReturn(recruitList);

        mockMvc.perform(get("/recruit"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].companyId").value(recruitSummaryDTO.getCompanyId()))
                .andExpect(jsonPath("$[0].position").value(recruitSummaryDTO.getPosition()))
                .andExpect(jsonPath("$[0].reward").value(recruitSummaryDTO.getReward()))
                .andExpect(jsonPath("$[0].tech").value(recruitSummaryDTO.getTech()))
                .andExpect(jsonPath("$[0].district").value(recruitSummaryDTO.getDistrict()));
    }

    @Test
    void searchRecruits_success() throws Exception {
        Recruit recruit = new Recruit();
        recruit.setCompanyId("id2");
        recruit.setPosition("Developer");
        recruit.setReward(3000000L);
        recruit.setDetail("프론트엔드 개발자 모집");
        recruit.setTech("React, Vue");
        recruit.setDistrict("성남시");

        List<Recruit> recruitList = Arrays.asList(recruit);
        when(recruitService.searchRecruits(anyString())).thenReturn(recruitList);

        mockMvc.perform(get("/recruit/search")
                        .param("search", "Developer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].companyId").value(recruit.getCompanyId()))
                .andExpect(jsonPath("$[0].position").value(recruit.getPosition()))
                .andExpect(jsonPath("$[0].reward").value(recruit.getReward()))
                .andExpect(jsonPath("$[0].tech").value(recruit.getTech()))
                .andExpect(jsonPath("$[0].district").value(recruit.getDistrict()));
    }

    @Test
    void getCustomRecruitById_success() throws Exception {
        CustomRecruitDTO customRecruitDTO = new CustomRecruitDTO();
        customRecruitDTO.setCompanyName("CompanyName");
        customRecruitDTO.setPosition("Developer");
        customRecruitDTO.setReward(3000000L);
        customRecruitDTO.setDetails("프론트엔드 개발자 모집");
        customRecruitDTO.setTech("React, Vue");
        customRecruitDTO.setDistrict("성남시");
        customRecruitDTO.setOtherJobPostings(Arrays.asList(1, 2, 3));

        when(recruitService.getCustomRecruitById(anyInt())).thenReturn(customRecruitDTO);

        mockMvc.perform(get("/recruit/detail/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.companyName").value(customRecruitDTO.getCompanyName()))
                .andExpect(jsonPath("$.position").value(customRecruitDTO.getPosition()))
                .andExpect(jsonPath("$.reward").value(customRecruitDTO.getReward()))
                .andExpect(jsonPath("$.details").value(customRecruitDTO.getDetails()))
                .andExpect(jsonPath("$.tech").value(customRecruitDTO.getTech()))
                .andExpect(jsonPath("$.district").value(customRecruitDTO.getDistrict()))
                .andExpect(jsonPath("$.otherJobPostings[0]").value(1));
    }

    @Test
    void getCustomRecruitById_notFound() throws Exception {
        when(recruitService.getCustomRecruitById(anyInt())).thenThrow(new RuntimeException("조회(해당 회사의 다른 공고 번호 포함) - 공고 번호 찾을 수 없음"));

        mockMvc.perform(get("/recruit/detail/1"))
                .andExpect(status().isNotFound());
    }
}
