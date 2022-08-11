package com.project.service;







import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
	userService service;

	
	@MockBean
	AcRepo repo;
	
	
	@Test
	void TestCreate() {
		UserTable ent = new UserTable( 0, "23dad", "Test");
		Mockito.when(this.repo.save(ent)).thenReturn(ent);
 
		Assertions.assertEquals(service.create(ent), service.MapToDTO(ent));
		Mockito.verify(this.repo, Mockito.times(1)).save(ent);	

	}
	
	@Test
	void TestRead() {
		UserTable ent = new UserTable(0, "23dad", "Test");
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
		UserTable ent = new UserTable(1, "23dad", "Test");
		Mockito.when(this.repo.save(ent)).thenReturn(ent);

		
	}
	@Test
	void TestDelete() {
		Mockito.doNothing().when(repo).delete(null);
	}

}
