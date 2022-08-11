package com.project.repo;






import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.boot.EntitiesApplication;
import com.project.entities.ItemsTable;



@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class ItemRepo{

	
	@Autowired
	ItemsRepo repo;
	@Test
	void TestRepoCreateRead() {
		ItemsTable res = new ItemsTable(1L,"test", 123456, 12, 2);
		Optional<ItemsTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(1L), ent);
	}

	@Test
	void TestRepoDelete() {
		Optional<ItemsTable> ent = Optional.empty();
		this.repo.deleteById(1L);
		Assertions.assertEquals(this.repo.findById(1L), ent);
	}
	
	@Test
	void TestRepoSave() {
		ItemsTable res = new ItemsTable(2L,"test", 12, 2, 123456);
		this.repo.save(res);
		Optional<ItemsTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(2L), ent);
	}

}
