package com.project.DTO;

import com.project.entities.UserTable;

import lombok.Data;

@Data
public class AcDTO {
	private long id;
	

	private String password;
	

	public String accName;
	
	AcDTO(){
		super();
	}
	public AcDTO(UserTable entity){
		super();
		this.id = entity.getId();
		this.password = entity.getPassword();
		this.accName = entity.getAccName();
	}

}
