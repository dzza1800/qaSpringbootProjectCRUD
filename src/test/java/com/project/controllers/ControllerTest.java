package com.project.controllers;

import org.junit.jupiter.api.BeforeEach;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

	
	final long id1 = 1L;
	final UserTable accCreate = new UserTable(1, "123", "test");
	final long id2 = 2L;
	final UserTable accRead = new UserTable(2, "1234", "test2");
	final long id3 = 3L;
	final UserTable accUpdate = new UserTable(3, "12345", "testupdate");
	@BeforeEach
	void dbWipe() {
		
	}
	@Test
    void testCreateController(){
		UserTable Acc = accCreate;
		Acc.setId(id2);
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
	
		List<UserTable> Acc = new ArrayList<UserTable>();
		accRead.setId(id2);
		Acc.add(accRead);
		Acc.add(accUpdate);
		
        try {
			this.mock
			    .perform(get("/getAllUsers")
			        .accept(MediaType.APPLICATION_JSON)
			        .contentType(MediaType.APPLICATION_JSON)
			        .content(this.objMap.writeValueAsString(Acc)))
			    .andExpect(status().isOk())
			    .andExpect(content().json(this.objMap.writeValueAsString(Acc)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
	void testDeleteController(){
		long id = id1;
        try {
			this.mock
			    .perform(put("/delete?id=" + id)
			        .accept(MediaType.APPLICATION_JSON)
			        .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Test
    void testUpdateController(){
		UserTable Acc = accUpdate;
        try {
			this.mock
			    .perform(put("/update?id=" + id3)
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

}
