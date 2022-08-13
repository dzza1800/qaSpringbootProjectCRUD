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
import com.project.DTO.orderDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.orderTable;


@SpringBootTest(classes= EntitiesApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OrderControllerTest {
	
	@Autowired
	MockMvc mock;
	@Autowired
	ModelMapper mapper;
	@Autowired
	ObjectMapper objMap;
	
	public orderDTO MapToDTO(orderTable entity) {
		return this.mapper.map(entity, orderDTO.class);
	}

	
	final long id1 = 1L;
	final orderTable orderCreate = new orderTable (1, 123343241, 5, true);
	final long id2 = 2L;
	final orderTable  orderRead = new orderTable (2, 123343242, 6, false);
	final long id3 = 3L;
	
	final orderTable  orderUpdate = new orderTable (3, 123343243, 5, false);
	@BeforeEach
	void dbWipe() {
		
	}
	@Test
    void testCreateController(){
		orderTable Acc = orderCreate;
		Acc.setId(id2);
        try {
			this.mock
			    .perform(post("/createOrderTest")
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
	
		List<orderDTO> Acc = new ArrayList<orderDTO>();
		orderRead.setId(id2);
		Acc.add(MapToDTO(orderRead));
		Acc.add(MapToDTO(orderUpdate));
        try {
			this.mock
			    .perform(get("/getAllOrders")
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
		boolean exists = false;
        try {
			this.mock
			    .perform(put("/deleteOrder?id=" + id)
			        .accept(MediaType.APPLICATION_JSON)
			        .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(content().json(this.objMap.writeValueAsString(exists)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Test
	void testDeleteUniqueController(){
		long id = 1213;
		boolean exists = false;
        try {
			this.mock
			    .perform(put("/deleteOrderUnique?id=" + id)
			        .accept(MediaType.APPLICATION_JSON)
			        .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(content().json(this.objMap.writeValueAsString(exists)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Test
    void testUpdateController(){
		orderTable Acc = orderUpdate;
        try {
			this.mock
			    .perform(put("/updateOrder?id=" + id3)
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
