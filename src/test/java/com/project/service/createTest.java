package com.project.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.project.DTO.AcDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.UserTable;
import com.project.repo.AcRepo;


@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class createTest {
	
	@Autowired
	@InjectMocks
	userService service;

	
	@MockBean
	AcRepo repo;
	
	
	@Test
	void TestCreate() {
		UserTable ent = new UserTable(1L, "23dad", "Test");
		Assertions.assertEquals(ent.getId(), 1L);
		Assertions.assertEquals(ent.getAccName(), "Test");
		Assertions.assertEquals(ent.getPassword(), "23dad");
		
		Mockito.when(this.repo.save(ent)).thenReturn(ent);
		Assertions.assertEquals(service.create(ent), service.MapToDTO(ent));
		Mockito.verify(this.repo, Mockito.times(1)).save(ent);	

	}
	
	@Test
	void TestRead() {
		UserTable ent = new UserTable(1L, "23dad", "Test");
		AcDTO dto = new AcDTO(ent);
		List<UserTable> account = new ArrayList<UserTable>();
		List<AcDTO> accDTO = new ArrayList<AcDTO>();
		accDTO.add(dto);
		account.add(ent);
		Mockito.when(this.repo.findAll()).thenReturn(account);
		Assertions.assertEquals(service.getAllUsers(), accDTO);
	}
	@Test
	void TestUpdate() {
		UserTable ent = new UserTable(1L, "dad", "Test");
		
		Mockito.when(this.repo.save(ent)).thenReturn(ent);
		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(ent));
		
		ent = new UserTable(0, "25dad", "test32");
		AcDTO updatedEnt = this.service.update(1L, ent);
		
		Assertions.assertEquals(updatedEnt.getAccName(), "test32");
		Assertions.assertEquals(updatedEnt.getPassword(), "25dad");
		
		
	}
	@Test
	void TestDelete() {
		long id = 1L;
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		Assertions.assertTrue(this.service.delete(id));
	}

}
