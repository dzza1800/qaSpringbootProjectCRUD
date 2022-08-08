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
public interface OrdersRepo extends JpaRepository<orderTable, Long>{

	//Custom queries for orders
	@Query(value = "SELECT * from order_table", nativeQuery = true)
	List<orderTable> findAllOrdersBySQL();
	
	@Query(value = "INSERT INTO order_table (orderUniqueID, orderQuantity, isProcessing) VALUES (?1, ?2, ?3)", nativeQuery = true)
	orderTable saveOrdersBySQL(Random rand, int quantity , boolean status);
	
	@Query(value = "UPDATE order_table SET isProcessing = ?1, orderQuantity = ?2 WHERE ID = ?3 ", nativeQuery = true)
	orderTable updateOrdersBySQL(boolean status, int quant, Long id);
	
	@Query(value = "DELETE FROM order_table WHERE ID = ?1", nativeQuery = true)
	List<orderTable> deleteOrdersBySQL(long id);
	
}
