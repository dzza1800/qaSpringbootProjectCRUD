package com.project.repo;






import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.boot.EntitiesApplication;
import com.project.entities.UserTable;
import com.project.entities.orderTable;



@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class OrderRepo{

	
	@Autowired
	OrdersRepo repo;
	@Test
	void TestRepoCreateRead() {
		orderTable res = new orderTable(1L, 12334324L, 2, true);
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

}
