package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.project.DTO.orderDTO;
import com.project.entities.orderTable;
import com.project.exceptions.IDNotFoundExceptions;
import com.project.repo.OrdersRepo;



@Service
public class orderService {

	private OrdersRepo repo;
	private ModelMapper mapper;
	
	public orderService(OrdersRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public List<orderDTO> getAllOrders() {
		  
	       return this.repo.findAll().stream().map(this::MapToDTO).collect(Collectors.toList());
	 }
	
	public orderDTO MapToDTO(orderTable entity) {
		return this.mapper.map(entity, orderDTO.class);
	}


public orderDTO create(orderTable entity) {
      entity = this.repo.save(entity);
      return this.MapToDTO(entity);
 }

public String createUnique(orderTable entity) {
	Random rand = new Random();
	long range = 9999999L;
	long number = (long)(rand.nextDouble()*range);
    this.repo.saveOrdersBySQL(number, entity.getOrderQuantity(), entity.getProcess());
    return "Order Created"; 
}


public boolean delete(long id) {
	if(!this.repo.existsById(id)) {
		throw new IDNotFoundExceptions();
	}
	else {

      this.repo.deleteById(id);
      boolean isExist = this.repo.existsById(id);
      return isExist; 
	}
 }
public boolean deleteUniqueID(long id) {
	if(this.repo.findAllUniqueBySQL(id) == null) {
		throw new IDNotFoundExceptions();
	}
	else {
    this.repo.deleteOrdersBySQLUniqueID(id);
    boolean isExist = true;
    return isExist; 
   }
}



public orderDTO update(long id, orderTable entity) {
	
	Optional<orderTable> existingOptional = this.repo.findById(id);
	orderTable ent = existingOptional.get();
	ent.setOrderQuantity(entity.getOrderQuantity());
	ent.setProcess(entity.getProcess());
	entity = this.repo.save(ent);
	return this.MapToDTO(entity);
 }
/*
public void updateUnique(long id, orderTable entity) {
	
	this.repo.findAllUniqueBySQL(id);
	this.repo.updateOrdersBySQL(entity.getOrderQuantity() , entity.getProcess(), entity.getOrderUniqueID());
	//return this.MapToDTO(entity);
 }*/

}
