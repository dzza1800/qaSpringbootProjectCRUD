package com.qa.DTO;

import java.util.Optional;

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

}
