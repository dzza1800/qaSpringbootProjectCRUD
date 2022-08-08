package com.project.repo;

import java.util.List;
import java.util.Random;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entities.ItemsTable;
import com.project.entities.UserTable;
import com.project.entities.orderTable;

@Repository
public interface ItemsRepo extends JpaRepository<ItemsTable, Long>{
	
	//Custom queries for items
	@Query(value = "SELECT * from items_table", nativeQuery = true)
	List<ItemsTable> findAllItemsBySQL();
	
	@Query(value = "INSERT INTO items_table (item_name, price, unique_itemid) VALUES (?1, ?2, ?3)", nativeQuery = true)
	ItemsTable saveItemBySQL(String name, long price, Random rand);
	
	@Query(value = "UPDATE items_table SET item_name = ?1, price = ?2 WHERE ID = ?3 ", nativeQuery = true)
	ItemsTable updateItemBySQL(String name, long price, Long id);
	
	@Query(value = "DELETE FROM items_table WHERE ID = ?1", nativeQuery = true)
	List<ItemsTable> deleteItemBySQL(long id);
	
	/*
	//Custom queries for orders
	@Query(value = "SELECT * from Orders", nativeQuery = true)
	List<orderTable> findAllOrdersBySQL();
	
	@Query(value = "INSERT INTO Orders (OrderID, orderStatus, orderPrice) VALUES (?1, ?2, ?3)", nativeQuery = true)
	orderTable saveOrdersBySQL(Random rand, String status ,long price);
	
	@Query(value = "UPDATE Orders SET orderStatus = ?1, orderPrice = ?2 WHERE ID = ?3 ", nativeQuery = true)
	orderTable updateOrdersBySQL(String status, long price, Long id);
	
	@Query(value = "DELETE FROM Orders WHERE ID = ?1", nativeQuery = true)
	List<orderTable> deleteOrdersBySQL(long id);
	*/
	
}
