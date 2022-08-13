package com.project.controllers;

import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.AcDTO;
import com.project.entities.UserTable;
import com.project.repo.AcRepo;
import com.project.service.userService;


@Service
@RestController
public class userController {
	
	userService ac;
	AcRepo repo;
	userController(userService ac, AcRepo repo){
		super();
		this.ac = ac;
		this.repo = repo;
		
	}
	
@GetMapping("/getAllUsers")
	public List<AcDTO> getAllUsers() {
	       return ac.getAllUsers();
	 }

@PostMapping("/createUser")
public AcDTO create(@RequestBody UserTable entity) {
      return ac.create(entity);
 }

@PutMapping("/delete")
public boolean delete(@PathParam("id") long id) {
      return ac.delete(id);
     
 }

@PutMapping("/update")
public AcDTO update(@PathParam("id") int id, @RequestBody UserTable entity) {
	return ac.update(id, entity);
 }

}
