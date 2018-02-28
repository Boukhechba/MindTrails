package org.mindtrails.controllers;

import org.junit.Test;
import org.mindtrails.controller.CoachController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CoachControllerTest extends BaseControllerTest {

    @Autowired
    private CoachController coachController;

    @Override
    public Object[] getControllers() {
        return new Object[]{coachController};
    }

    @Test
    public void testAccessCoachAsNoOne() throws Exception {
        // Assure we get redirected if we aren't an admin
        mockMvc.perform(get("/coach"))
                .andExpect((status().is3xxRedirection()));
    }

    @Test
    public void testAccessCoachAsParticipant() throws Exception {
        // Assure we get redirected if we aren't an admin
        mockMvc.perform(get("/coach")
                .with(SecurityMockMvcRequestPostProcessors.user(participant)))
                .andExpect((status().is4xxClientError()));
    }

    @Test
    public void testAccessCoachAsAdmin() throws Exception {
        // Assure we get redirected if we aren't an admin
        mockMvc.perform(get("/coach")
                .with(SecurityMockMvcRequestPostProcessors.user(admin)))
                .andExpect((status().is2xxSuccessful()));
    }

    @Test
    public void testAccessCoachAsCoach() throws Exception {
        // Assure we get redirected if we aren't an admin
        mockMvc.perform(get("/coach")
                .with(SecurityMockMvcRequestPostProcessors.user(coach)))
                .andExpect((status().is2xxSuccessful()));
    }

}

