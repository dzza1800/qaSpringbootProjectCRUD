package com.project.repo;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.project.entities.UserTable;
import com.project.service.userService;


@SpringBootTest
@ActiveProfiles("prod")
class repoTest {
	
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
	

}
