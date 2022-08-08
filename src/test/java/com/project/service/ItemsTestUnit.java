package com.project.service;







import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

import com.project.DTO.AcDTO;
import com.project.DTO.ItemsDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.ItemsTable;
import com.project.entities.UserTable;
import com.project.repo.AcRepo;
import com.project.repo.ItemsRepo;


@SpringBootTest(classes = EntitiesApplication.class)
@ActiveProfiles("test")
class ItemsTestUnit {
	
	@Autowired
	ItemsService service;

	
	@MockBean
	ItemsRepo repo;
	
	
	@Test
	void TestCreate() {
		ItemsTable ent = new ItemsTable( 0, "car", "124unituqdate", 12354L, 3);
		Mockito.when(this.repo.save(ent)).thenReturn(ent);
 
		Assertions.assertEquals(service.create(ent), service.MapToDTO(ent));
		Mockito.verify(this.repo, Mockito.times(1)).save(ent);	

	}
	
	@Test
	void TestRead() {
		ItemsTable ent = new ItemsTable( 0, "car", "124unituqdate", 12354L, 3);
		ItemsDTO dto = new ItemsDTO(ent);
		List<ItemsTable> account = new ArrayList<ItemsTable>();
		List<ItemsDTO> accDTO = new ArrayList<ItemsDTO>();
		accDTO.add(dto);
		account.add(ent);
		Mockito.when(this.repo.findAll()).thenReturn(account);
		Assertions.assertEquals(service.getAllUsers(), accDTO);
	}
	
	@Test
	void TestDelete() {
		Mockito.doNothing().when(repo).delete(null);
	}

}
