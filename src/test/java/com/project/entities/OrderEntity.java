package com.project.entities;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OrderEntity {

	@Test
	void TestOrderEntity() {
		orderTable ent = new orderTable(1L, 123343241L, 5, true);

		Assertions.assertEquals(ent.getId(), 1L);
		Assertions.assertEquals(ent.getOrderUniqueID(),123343241 );
		Assertions.assertEquals(ent.getOrderQuantity(), 5);
	}
	@Test
	void EntityEquals() {
		
		orderTable orderEnt = new orderTable(1L, 123343241L, 5, true);
		orderTable orderEnt2 = new orderTable(1L, 123343241L, 5, true);
		Assertions.assertTrue(orderEnt.equals(orderEnt2));
		Assertions.assertTrue(orderEnt.hashCode()==orderEnt2.hashCode());
	}
}
