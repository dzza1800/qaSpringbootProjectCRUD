package com.example.demo;




import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.project.boot.EntitiesApplication;


@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class EntitiesApplicationTests {

	@Test
	void contextLoads() {
	}


}
