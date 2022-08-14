package com.project.repo;






import java.util.Optional;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.boot.EntitiesApplication;

import com.project.entities.orderTable;



@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class OrderRepo{

	
	@Autowired
	OrdersRepo repo;
	
	@Test
	void TestRepoCreate() {
		orderTable res = new orderTable(1L, 123343241L, 5, true);
		Optional<orderTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(1L), ent);
	}

	@Test
	void TestRepoDelete() {
		Optional<orderTable> ent = Optional.empty();
		this.repo.deleteById(1L);
		Assertions.assertEquals(this.repo.findById(1L), ent);
	}
	
	@Test
	void TestRepoSave() {
		orderTable res = new orderTable(2L, 12334324L, 2, true);
		this.repo.save(res);
		Optional<orderTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(2L), ent);
	}
	@Test
	void TestRepoReadByUniqueID() {
		orderTable res = new orderTable(4L, 123343242L, 6, false);
		this.repo.save(res);
		Assertions.assertEquals(this.repo.findAllUniqueBySQL(123343242), res);
	}
	@Test
	void TestRepoCreateBySQL() {
		orderTable res = new orderTable(5L, 11111, 8, true);
		Optional<orderTable> ent = Optional.of(res);
		this.repo.saveOrdersBySQL(res.getOrderUniqueID(), res.getOrderQuantity(), res.getProcess());
		Assertions.assertEquals(this.repo.findById(5L), ent);
	}
	@Test
	void TestRepoUpdateBySQL() {
		
		orderTable updatedRes = new orderTable(2L, 12334324L, 4, true);
		Optional<orderTable> ent = Optional.of(updatedRes);
		this.repo.updateOrdersBySQL(updatedRes.getOrderQuantity(), updatedRes.getProcess(), 12334324);
		
		Assertions.assertEquals(this.repo.findById(2L), ent);
	}
	@Test
	void TestRepoDeleteBySQL() {
		orderTable res = new orderTable(3L, 123343242L, 6, false);
		Optional<orderTable> ent = Optional.empty();
		this.repo.save(res);
		this.repo.deleteOrdersBySQLUniqueID(123343242);
		Assertions.assertEquals(this.repo.findById(3L), ent);
	}

}
