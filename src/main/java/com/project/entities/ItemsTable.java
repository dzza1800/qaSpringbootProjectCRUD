package com.project.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemsTable {
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	String ItemName;
	
	@Column(unique = true, nullable = false)
	String uniqueItemID;
	
	@Column(nullable = false)
	long price;
	
	@Column(nullable = false)
	int stock;

}
