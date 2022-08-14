package com.project.entities;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ItemEntity {

	@Test
	void TestItemEntity() {
		ItemsTable ent = new ItemsTable(1L, "Test", 123, 12, 1);
		
		Assertions.assertEquals(ent.getId(), 1L);
		Assertions.assertEquals(ent.getUniqueItemID(), 123);
		Assertions.assertEquals(ent.getPrice(), 12);
		Assertions.assertEquals(ent.getStock(), 1);
	}
	@Test
	void EntityEquals() {

		ItemsTable itemEnt = new ItemsTable(1L, "Test", 123, 12, 1);
		ItemsTable itemEnt2 = new ItemsTable(1L, "Test", 123, 12, 1);
		Assertions.assertTrue(itemEnt.equals(itemEnt2));
		Assertions.assertTrue(itemEnt.hashCode()==itemEnt2.hashCode());

	}
}
