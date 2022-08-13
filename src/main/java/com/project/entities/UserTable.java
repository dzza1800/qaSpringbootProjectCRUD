package com.project.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = false, nullable = false)
	private String Password;
	
	@Column(unique = true, nullable = false)
	private String accName;
}
