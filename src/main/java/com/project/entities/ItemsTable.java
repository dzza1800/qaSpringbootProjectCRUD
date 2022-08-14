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
public class ItemsTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	String ItemName;
	
	@Column(unique = true, nullable = false)
	private int uniqueItemID;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private int stock;
	
	public ItemsTable(String ItemName, double price, int stock){
		this.ItemName = ItemName;
		this.price = price;
		this.stock = stock;
	}

}
