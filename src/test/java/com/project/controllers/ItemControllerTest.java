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
import com.project.DTO.ItemsDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.ItemsTable;



@SpringBootTest(classes= EntitiesApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ItemControllerTest {
	
	@Autowired
	MockMvc mock;
	@Autowired
	ModelMapper mapper;
	@Autowired
	ObjectMapper objMap;
	
	public ItemsDTO MapToDTO(ItemsTable entity) {
		return this.mapper.map(entity, ItemsDTO.class);
	}

	
	final long id1 = 1L;
	final ItemsTable itemCreate = new ItemsTable(1,"test", 123456, 12, 2);
	final long id2 = 2L;
	final ItemsTable itemRead = new ItemsTable(2,"test2", 1234567, 13, 3);
	final long id3 = 3L;
	final ItemsTable itemUpdate = new ItemsTable(3,"testupdate", 1234568, 14, 4);
	@BeforeEach
	void dbWipe() {
		
	}
	@Test
    void testCreateController(){
		ItemsTable Acc = itemCreate;
		Acc.setId(id2);
        try {
			this.mock
			    .perform(post("/createItems")
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
	
		List<ItemsTable> Acc = new ArrayList<ItemsTable>();
		Acc.add(itemRead);
		Acc.add(itemUpdate);
		
        try {
			this.mock
			    .perform(get("/getAllItems")
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
			    .perform(put("/deleteItem?id=" + id)
			        .accept(MediaType.APPLICATION_JSON)
			        .contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
	void testDeleteUniqueController(){
		long id = 12345689;
        try {
			this.mock
			    .perform(put("/deleteItemUnique?id=" + id)
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
		ItemsTable Acc = itemUpdate;
        try {
			this.mock
			    .perform(put("/updateItem?id=" + id3)
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
