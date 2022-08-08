package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.project.DTO.orderDTO;
import com.project.entities.orderTable;
import com.project.exceptions.AccountNotFoundExceptions;
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


public boolean delete(long id) {
	  orderTable ent = this.repo.findById(id).orElseThrow(AccountNotFoundExceptions::new);
      this.repo.deleteById(id);
      boolean isExist = this.repo.existsById(id);
      return isExist; 
     
 }


public orderDTO update(long id, orderTable entity) {
	
	Optional<orderTable> existingOptional = this.repo.findById(id);
	orderTable ent = existingOptional.get();
	ent.setOrderQuantity(entity.getOrderQuantity());
	ent.isProcessing();
	entity = this.repo.save(ent);
	return this.MapToDTO(entity);
 }

}
