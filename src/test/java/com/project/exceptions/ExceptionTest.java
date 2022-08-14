package com.project.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import com.project.boot.EntitiesApplication;
import com.project.repo.AcRepo;
import com.project.repo.ItemsRepo;
import com.project.repo.OrdersRepo;
import com.project.service.ItemsService;
import com.project.service.orderService;
import com.project.service.userService;


@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class ExceptionTest {
	@MockBean
	AcRepo repo;
	@MockBean
	OrdersRepo orderrepo;
	@MockBean
	ItemsRepo itemsrepo;
	@Autowired
	@InjectMocks
	ItemsService Itemservice;
	
	@Autowired
	@InjectMocks
	userService userservice;
	
	@Autowired
	@InjectMocks
	orderService orderservice;
	

	
	@Test
	void TestAcRepo() {
		Assertions.assertThrows(IDNotFoundExceptions.class, () -> userservice.delete(1L));
		}
	@Test
	void TestItemRepo() {
		Assertions.assertThrows(IDNotFoundExceptions.class, () -> Itemservice.delete(1L));
		}
	@Test
	void TestOrderRepo() {
		Assertions.assertThrows(IDNotFoundExceptions.class, () -> orderservice.delete(1L));
		}
}
