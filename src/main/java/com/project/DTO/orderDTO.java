package com.project.DTO;


import com.project.entities.orderTable;

import lombok.*;

@Data
@NoArgsConstructor
public class orderDTO {


private long id;

private long orderUniqueID;

public int orderQuantity;

public boolean isProcessing;

public orderDTO(orderTable entity) {
	this.id = entity.getId();
	this.orderUniqueID = entity.getOrderUniqueID();
	this.orderQuantity = entity.getOrderQuantity();
	this.isProcessing = entity.isProcessing();
}
}
