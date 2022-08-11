package com.project.controllers;

import java.util.*;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.orderDTO;
import com.project.entities.orderTable;
import com.project.repo.OrdersRepo;
import com.project.service.orderService;


@Service
@RestController
public class orderController {
	
	orderService ac;
	OrdersRepo repo;
	orderController(orderService ac, OrdersRepo repo){
		super();
		this.ac = ac;
		this.repo = repo;
		
	}
	
@RequestMapping("/getAllOrders")
	public List<orderDTO> getAllOrders() {
	       return ac.getAllOrders();
	 }

@PostMapping("/createOrder")
public String create(@RequestBody orderTable entity) {
      return ac.createUnique(entity);
 }

@PutMapping("/deleteOrder")
public boolean delete(@PathParam("id") long id) {
      return ac.delete(id);
 }

@PutMapping("/deleteOrderUnique")
public boolean deleteUnique(@PathParam("id") long id) {
      return ac.deleteUniqueID(id);
 }

@PutMapping("/updateOrder")
public void update(@PathParam("id") long id, @RequestBody orderTable entity) {
	ac.update(id, entity);
 }
}
