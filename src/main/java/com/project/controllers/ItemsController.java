package com.project.controllers;

import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.DTO.ItemsDTO;
import com.project.entities.ItemsTable;
import com.project.repo.ItemsRepo;
import com.project.service.ItemsService;


@Service
@RestController
public class ItemsController {
	
	ItemsService ac;
	ItemsRepo repo;
	ItemsController(ItemsService ac, ItemsRepo repo){
		super();
		this.ac = ac;
		this.repo = repo;
		
	}
	
@RequestMapping("/getAllItems")
	public List<ItemsDTO> getAllUsers() {
	       return ac.getAllUsers();
	 }

@PostMapping("/createItems")
public ItemsDTO create(@RequestBody ItemsTable entity) {
      return ac.create(entity);
 }
@PostMapping("/createUnique")
public String createUnique(@RequestBody ItemsTable entity) {
      return ac.createUni(entity);
 }
@PutMapping("/deleteItemUnique")
public boolean deleteUniqueID(@PathParam("id") long id) {
      return ac.deleteUniqueID(id);
 }


@PutMapping("/deleteItem")
public boolean delete(@PathParam("id") long id) {
      return ac.delete(id);
 }


@PutMapping("/updateItem")
public ItemsDTO update(@PathParam("id") long id, @RequestBody ItemsTable entity) {
	return ac.update(id, entity);
 }
}
