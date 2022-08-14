package com.qa.DTO;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.DTO.AcDTO;
import com.project.DTO.ItemsDTO;
import com.project.DTO.orderDTO;
import com.project.entities.ItemsTable;
import com.project.entities.UserTable;
import com.project.entities.orderTable;
import com.project.repo.AcRepo;

public class DTOTests {
	@Autowired
	AcRepo repo;
	@Test
	void TestUserDTO() {
		UserTable ent = new UserTable(1L, "123", "test");
		AcDTO res = new AcDTO(ent);
		Assertions.assertEquals(res.getId(), 1L);
		Assertions.assertEquals(res.getPassword(), "123");
		Assertions.assertEquals(res.getAccName(), "test");
	}
	@Test
	void TestItemDTO() {
		ItemsTable ent = new ItemsTable(1L, "Test", 123, 12, 1);
		ItemsDTO res = new ItemsDTO(ent);
		Assertions.assertEquals(res.getId(), 1L);
		Assertions.assertEquals(res.getUniqueItemID(), 123);
		Assertions.assertEquals(res.getPrice(), 12);
		Assertions.assertEquals(res.getStock(), 1);
	}
	@Test
	void TestOrderDTO() {
		orderTable ent = new orderTable(1L, 123343241L, 5, true);
		orderDTO res = new orderDTO(ent);
		Assertions.assertEquals(res.getId(), 1L);
		Assertions.assertEquals(res.getOrderUniqueID(),123343241 );
		Assertions.assertEquals(res.getOrderQuantity(), 5);
	}
	@Test
	void DTOUserEquals() {
		UserTable ent = new UserTable(1L, "123", "test");
		UserTable ent2 = new UserTable(1L, "123", "test");
		
		AcDTO res = new AcDTO(ent);
		AcDTO res2 = new AcDTO(ent2);
		
		Assertions.assertTrue(res.equals(res2));
		Assertions.assertTrue(res.hashCode()==res2.hashCode());

	}
	@Test
	void DTOItemsEquals() {
		
		ItemsTable ent = new ItemsTable(1L, "Test", 123, 12, 1);
		ItemsTable ent2 = new ItemsTable(1L, "Test", 123, 12, 1);
		
		ItemsDTO res = new ItemsDTO(ent);
		ItemsDTO res2 = new ItemsDTO(ent2);
		
		Assertions.assertTrue(res.equals(res2));
		Assertions.assertTrue(res.hashCode()==res2.hashCode());
	}
	
	@Test
	void DTOOrdersEquals() {
		
		orderTable ent = new orderTable(1L, 123343241L, 5, true);
		orderTable ent2 = new orderTable(1L, 123343241L, 5, true);
		
		orderDTO res = new orderDTO(ent);
		orderDTO res2 = new orderDTO(ent2);
		Assertions.assertTrue(res.equals(res2));
		Assertions.assertTrue(res.hashCode()==res2.hashCode());
	}

}
