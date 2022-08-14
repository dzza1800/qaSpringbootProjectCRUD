package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import com.project.DTO.orderDTO;
import com.project.boot.EntitiesApplication;
import com.project.entities.orderTable;
import com.project.exceptions.IDNotFoundExceptions;
import com.project.repo.OrdersRepo;


@SpringBootTest(classes= EntitiesApplication.class)
@ActiveProfiles("test")
class orderTest {
	
	@Autowired
	@InjectMocks
	orderService service;

	
	@MockBean
	OrdersRepo repo;
	
	
	@Test
	void TestCreate() {
		orderTable ent = new orderTable(1L,100, 100 ,true );
		Assertions.assertEquals(ent.getId(), 1L);
		Assertions.assertEquals(ent.getOrderUniqueID(),100 );
		Assertions.assertEquals(ent.getOrderQuantity(), 100);
		Assertions.assertEquals(ent.getProcess(), true);
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
	void TestUpdate() {
		orderTable ent = new orderTable(1,100, 100 ,true);
		
		Mockito.when(this.repo.save(ent)).thenReturn(ent);
		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(ent));
		
		ent = new orderTable(0,11, 150 ,false);
		orderDTO updatedEnt = this.service.update(1L, ent);
		//unique id should not change, but everything else should
		Assertions.assertEquals(updatedEnt.getOrderUniqueID(), 100);
		Assertions.assertEquals(updatedEnt.getOrderQuantity(), 150);
		Assertions.assertEquals(updatedEnt.getId(), 1);
	}
	
	@Test
	void TestDelete() {
		long id = 1L;
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		Assertions.assertTrue(this.service.delete(id));
	}
	@Test
	void TestDeleteExceptions() {
		long id = 0;
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		Assertions.assertThrows(IDNotFoundExceptions.class, () -> this.service.delete(id));
	}
	@Test
	void TestDeleteUnique() {
		orderTable ent = new orderTable(1,100, 100 ,true);
		long id = 100;
		Mockito.when(this.repo.findAllUniqueBySQL(id)).thenReturn(ent);
		Assertions.assertTrue(this.service.deleteUniqueID(id));
	}
	
	@Test
	void TestDeleteUniqueException() {
		
		long id = 1;
		Assertions.assertThrows(IDNotFoundExceptions.class, () -> this.service.deleteUniqueID(id));
	}
	
	@Test
	void TestCreateUnique() {
		orderTable res = new orderTable(1L, 2, true);
		Assertions.assertEquals(service.createUnique(res), "Order Created");
	}

}
