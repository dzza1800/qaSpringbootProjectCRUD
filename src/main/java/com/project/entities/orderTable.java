package com.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class orderTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false)
	private long orderUniqueID;
	
	@Column(unique = false, nullable = false)
	private int orderQuantity;
	
	@Column(unique = false, nullable = false)
	private boolean isProcessing;
	
	public void setProcess(boolean process) {
		this.isProcessing = process;
	}
	public boolean getProcess() {
		return this.isProcessing;
	}
	public orderTable(long id, int orderQuantity, boolean isProcessing) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.orderQuantity = orderQuantity;
		this.isProcessing = isProcessing;
	}
}
