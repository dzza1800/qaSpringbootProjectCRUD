package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.DTO.ItemsDTO;
import com.project.entities.ItemsTable;
import com.project.exceptions.IDNotFoundExceptions;
import com.project.repo.ItemsRepo;




@Service
public class ItemsService {
	private ItemsRepo repo;
	private ModelMapper mapper;
	
	public ItemsService(ItemsRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public List<ItemsDTO> getAllUsers() {
		  
	       return this.repo.findAll().stream().map(this::MapToDTO).collect(Collectors.toList());
	 }
	
	public ItemsDTO MapToDTO(ItemsTable entity) {
		return this.mapper.map(entity, ItemsDTO.class);
	}


public ItemsDTO create(ItemsTable entity) {
      entity = this.repo.save(entity);
      return this.MapToDTO(entity);
 }


public boolean delete(long id) {
	  ItemsTable ent = this.repo.findById(id).orElseThrow(IDNotFoundExceptions::new);
      this.repo.deleteById(id);
      boolean isExist = this.repo.existsById(id);
      return isExist; 
     
 }
public boolean deleteUniqueID(long id) {
	ItemsTable ent = this.repo.findAllItemsBySQL(id);
    this.repo.deleteItemBySQL(id);
    boolean isExist = this.repo.existsById(id);
    return isExist; 
   
}

public ItemsDTO update(long id, ItemsTable entity) {
	
	Optional<ItemsTable> existingOptional = this.repo.findById(id);
	ItemsTable ent = existingOptional.get();
	ent.setItemName(entity.getItemName());
	ent.setPrice(entity.getPrice());
	ent.setStock(entity.getStock());
	entity = this.repo.save(ent);
	return this.MapToDTO(entity);
 }

public String createUni(ItemsTable entity) {
	Random rand = new Random();
	long range = 9999999L;
	long number = (long)(rand.nextDouble()*range);
    this.repo.saveItemBySQL(entity.getItemName(),entity.getPrice(),entity.getStock(), number);
    return "Coin created with Id: " + number; 
}

}
