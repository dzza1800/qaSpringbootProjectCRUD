package com.project.service;







import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

import com.project.DTO.AcDTO;
import com.project.DTO.orderDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.UserTable;
import com.project.entities.orderTable;
import com.project.repo.AcRepo;
import com.project.repo.OrdersRepo;


@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class orderTest {
	
	@Autowired
	orderService service;

	
	@MockBean
	OrdersRepo repo;
	
	
	@Test
	void TestCreate() {
		orderTable ent = new orderTable( 0,100, 100 ,true );
		Mockito.when(this.repo.save(ent)).thenReturn(ent);
 
		Assertions.assertEquals(service.create(ent), service.MapToDTO(ent));
		Mockito.verify(this.repo, Mockito.times(1)).save(ent);	

	}
	
	@Test
	void TestRead() {
		orderTable ent = new orderTable(0,100, 100 ,true );
		orderDTO dto = new orderDTO(ent);
		List<orderTable> account = new ArrayList<orderTable>();
		List<orderDTO> accDTO = new ArrayList<orderDTO>();
		accDTO.add(dto);
		account.add(ent);
		Mockito.when(this.repo.findAll()).thenReturn(account);
		Assertions.assertEquals(service.getAllOrders(), accDTO);
	}
	
	@Test
	void TestDelete() {
		Mockito.doNothing().when(repo).delete(null);
	}

}
