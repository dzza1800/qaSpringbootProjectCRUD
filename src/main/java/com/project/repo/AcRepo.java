package com.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.entities.UserTable;


@Repository
public interface AcRepo extends JpaRepository<UserTable, Long>{
	//Custom queries for users
	@Query(value = "SELECT * from user_table WHERE acc_name = ?1", nativeQuery = true)
	UserTable findUserBySQL(String username);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user_table (acc_name, password) VALUES (?1, ?2)", nativeQuery = true)
	void saveBySQL(String name, String password);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user_table SET acc_name = ?1, password = ?2 WHERE ID = ?3 ", nativeQuery = true)
	void updateBySQL(String name, String accNum, Long id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM user_table WHERE ID = ?1", nativeQuery = true)
	void deleteBySQL(long id);
	
	
	
}
