package com.project.DTO;


import com.project.entities.ItemsTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemsDTO {
	private long id;
	
	String ItemName;
	
	double price;
	
	int stock;
	
	int uniqueItemID;

	public ItemsDTO(ItemsTable entity){
		super();
		this.id = entity.getId();
		this.ItemName = entity.getItemName();
		this.price = entity.getPrice();
		this.stock = entity.getStock();
		this.uniqueItemID = entity.getUniqueItemID();
	}

}
