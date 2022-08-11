package com.project.controllers;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.DTO.AcDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.UserTable;


@SpringBootTest(classes= EntitiesApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ControllerTest {
	
	@Autowired
	MockMvc mock;
	@Autowired
	ModelMapper mapper;
	@Autowired
	ObjectMapper objMap;
	
	public AcDTO MapToDTO(UserTable entity) {
		return this.mapper.map(entity, AcDTO.class);
	}

	
	final Long id = 1L;
	final UserTable acc = new UserTable(1L, "dsda", "dasdasd");
	@Test
    void testCreateController(){
		UserTable Acc = acc;
		Acc.setId(id);
        try {
			this.mock
			    .perform(post("/createUser")
			        .accept(MediaType.APPLICATION_JSON)
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(this.objMap.writeValueAsString(Acc)))
			    .andExpect(status().isOk())
			    .andExpect(content().json(this.objMap.writeValueAsString(this.MapToDTO(Acc))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
	void testReadController(){
		UserTable Acc = acc;
		Acc.setId(id);
        try {
			this.mock
			    .perform(get("/getAllUsers")
			        .accept(MediaType.APPLICATION_JSON)
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(this.objMap.writeValueAsString(Acc)))
			    .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
