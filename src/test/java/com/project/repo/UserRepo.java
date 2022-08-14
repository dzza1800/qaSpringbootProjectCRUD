package com.project.repo;






import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
		UserTable res = new UserTable(4, "123", "test");
		this.repo.save(res);
		Optional<UserTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(4L), ent);
	}
	@Test
	void TestRepoFind() {
		UserTable res = new UserTable(4L, "12345678", "tes3343");
		this.repo.save(res);
		Optional<UserTable> ent = Optional.of(res);
		Assertions.assertEquals(this.repo.findById(4L), ent);
	}
	@Test
	void TestRepoDeleteSQL() {
		Optional<UserTable> ent = Optional.empty();
		this.repo.deleteBySQL(1L);
		Assertions.assertEquals(this.repo.findById(1L), ent);
	}
	@Test
	void TestRepoSaveBySQL() {
		UserTable res = new UserTable(5L, "1234", "test124xxx");
		this.repo.saveBySQL(res.getAccName(), res.getPassword());
		Optional<UserTable> ent = Optional.of(res);
		
		Assertions.assertEquals(this.repo.findById(5L), ent);
	}
	@Test
	void TestRepoFindBySQL() {
		UserTable res = new UserTable(2L, "1234", "test2");

		Assertions.assertEquals(this.repo.findUserBySQL("test2"), res);
	}

}
