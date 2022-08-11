package com.project.repo;

import java.util.List;
import java.util.Random;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.ItemsTable;
import com.project.entities.UserTable;
import com.project.entities.orderTable;

@Repository
public interface OrdersRepo extends JpaRepository<orderTable, Long>{

	//Custom queries for orders
	
	@Query(value = "SELECT * from order_table WHERE order_uniqueid = ?1", nativeQuery = true)
	orderTable findAllUniqueBySQL(long id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO order_table (order_uniqueid, order_quantity, is_processing) VALUES (?1, ?2, ?3)", nativeQuery = true)
	void saveOrdersBySQL(long number, int quantity , boolean status);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE order_table SET order_quantity = ?1, is_processing = ?2 WHERE order_uniqueid = ?3", nativeQuery = true)
	void updateOrdersBySQL(int quantity , boolean status, long id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM order_table WHERE order_uniqueid = ?1", nativeQuery = true)
	void deleteOrdersBySQLUniqueID(long UniqueID);
}
