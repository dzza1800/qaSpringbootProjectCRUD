package com.project.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entities.ItemsTable;


@Repository
public interface ItemsRepo extends JpaRepository<ItemsTable, Long>{
	
	//Custom queries for items
	@Query(value = "SELECT * from items_table WHERE unique_itemid = ?1", nativeQuery = true)
	ItemsTable findItemByUniqueIDSQL(long id);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO items_table (item_name, price, stock ,unique_itemid) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	void saveItemBySQL(String name, double price, int stock ,long number);
	
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM items_table WHERE unique_itemid = ?1", nativeQuery = true)
	void deleteItemBySQL(long id);
	
}
