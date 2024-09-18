package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hospitalId;
	private String hospitalName;
	private String hospitalAddress;
	private String phoneNumber;
	

}
