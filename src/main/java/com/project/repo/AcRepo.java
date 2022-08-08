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
public interface AcRepo extends JpaRepository<UserTable, Long>{
	//Custom queries for users
	@Query(value = "SELECT * from user_table", nativeQuery = true)
	List<UserTable> findAllBySQL();
	
	@Query(value = "INSERT INTO UserTable (acc_name, password) VALUES (?1, ?2)", nativeQuery = true)
	UserTable saveBySQL(String name, String password);
	
	@Query(value = "UPDATE UserTable SET acc_name = ?1, password = ?2 WHERE ID = ?3 ", nativeQuery = true)
	UserTable updateBySQL(String name, String accNum, Long id);
	
	@Query(value = "DELETE FROM UserTable WHERE ID = ?1", nativeQuery = true)
	List<UserTable> deleteBySQL(long id);
	
	
}
