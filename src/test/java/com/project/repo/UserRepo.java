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



@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class UserRepo{

	
	@Autowired
	AcRepo repo;
	@Test
	void TestRepoCreateRead() {
		UserTable res = new UserTable(1L, "123", "test");
		Optional<UserTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(1L), ent);
	}

	@Test
	void TestRepoDelete() {
		Optional<UserTable> ent = Optional.empty();
		this.repo.deleteById(1L);
		Assertions.assertEquals(this.repo.findById(1L), ent);
	}
	
	@Test
	void TestRepoSave() {
		UserTable res = new UserTable(0, "123", "test");
		this.repo.save(res);
		Optional<UserTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(2L), ent);
	}

}
