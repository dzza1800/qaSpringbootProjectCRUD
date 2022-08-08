package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.DTO.AcDTO;
import com.project.entities.UserTable;
import com.project.exceptions.AccountNotFoundExceptions;
import com.project.repo.AcRepo;


@Service
public class userService {

	private AcRepo repo;
	private ModelMapper mapper;
	
	public userService(AcRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public List<AcDTO> getAllUsers() {
		  
	       return this.repo.findAll().stream().map(this::MapToDTO).collect(Collectors.toList());
	 }
	
	public AcDTO MapToDTO(UserTable entity) {
		return this.mapper.map(entity, AcDTO.class);
	}


public AcDTO create(UserTable entity) {
      entity = this.repo.save(entity);
      return this.MapToDTO(entity);
 }


public boolean delete(long id) {
	  UserTable ent = this.repo.findById(id).orElseThrow(AccountNotFoundExceptions::new);
      this.repo.deleteById(id);
      boolean isExist = this.repo.existsById(id);
      return isExist; 
     
 }


public AcDTO update(long id, UserTable entity) {
	
	Optional<UserTable> existingOptional = this.repo.findById(id);
	UserTable ent = existingOptional.get();
	ent.setAccName(entity.getAccName());
	ent.setPassword(entity.getPassword());
	entity = this.repo.save(ent);
	return this.MapToDTO(entity);
 }

}
