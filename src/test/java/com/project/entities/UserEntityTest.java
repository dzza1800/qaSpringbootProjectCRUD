package com.project.entities;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserEntityTest {

	@Test
	void TestUserEntity() {
		UserTable ent = new UserTable(1L, "123", "test");

		Assertions.assertEquals(ent.getId(), 1L);
		Assertions.assertEquals(ent.getPassword(), "123");
		Assertions.assertEquals(ent.getAccName(), "test");
	}
	@Test
	void EntityEquals() {
		UserTable ent = new UserTable(1L, "123", "test");
		UserTable ent2 = new UserTable(1L, "123", "test");
		Assertions.assertTrue(ent.equals(ent2));
		Assertions.assertTrue(ent.hashCode()==ent2.hashCode());
	}
}
