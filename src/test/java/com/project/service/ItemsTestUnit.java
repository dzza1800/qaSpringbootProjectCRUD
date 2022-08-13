package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import com.project.DTO.ItemsDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.ItemsTable;
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
		ItemsTable res = new ItemsTable(1L, "car", 1234234234, 12354, 3);
		Assertions.assertEquals(res.getId(), 1L);
		Assertions.assertEquals(res.getItemName(), "car");
		Assertions.assertEquals(res.getUniqueItemID(), 1234234234);
		Assertions.assertEquals(res.getPrice(), 12354);
		Assertions.assertEquals(res.getStock(), 3);
		Mockito.when(this.repo.save(res)).thenReturn(res);
 
		Assertions.assertEquals(service.create(res), service.MapToDTO(res));
		Mockito.verify(this.repo, Mockito.times(1)).save(res);	

	}
	
	@Test
	void TestRead() {
		ItemsTable ent = new ItemsTable(0, "car", 1234234234, 12354, 3);
		ItemsDTO dto = new ItemsDTO(ent);
		List<ItemsTable> account = new ArrayList<ItemsTable>();
		List<ItemsDTO> accDTO = new ArrayList<ItemsDTO>();
		accDTO.add(dto);
		account.add(ent);
		Mockito.when(this.repo.findAll()).thenReturn(account);
		Assertions.assertEquals(service.getAllUsers(), accDTO);
	}
	
	@Test
	void TestUpdate() {
		ItemsTable ent = new ItemsTable(1, "car", 1234234234, 12354, 3);
		
		Mockito.when(this.repo.save(ent)).thenReturn(ent);
		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(ent));
		
		ent = new ItemsTable(0, "Plane", 123, 100, 7);
		ItemsDTO updatedEnt = this.service.update(1L, ent);
	    //as the unique item id is set not to change, it shouldn't change at all
		Assertions.assertEquals(updatedEnt.getUniqueItemID(), 1234234234);
		Assertions.assertEquals(updatedEnt.getItemName(), "Plane");
		Assertions.assertEquals(updatedEnt.getPrice(), 100);
		Assertions.assertEquals(updatedEnt.getStock(), 7);
		
		
	}
	
	@Test
	void TestDelete() {
		long id = 1L;
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		Assertions.assertTrue(service.delete(id));
	}
	
	@Test
	void TestCreateUnique() {
		ItemsTable res = new ItemsTable("car", 12354, 3);
		Assertions.assertEquals(service.createUni(res), "Item created");
	}

}
