package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Hospital;
import com.app.service.HospitalService;

@RestController
@RequestMapping("api")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Hospital>> getAllHospitals()
	{
		
		List<Hospital> hospitals = hospitalService.getAllHospitals();
		return new ResponseEntity<>(hospitals, HttpStatus.OK);
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id)
	{
		Optional<Hospital> hospital = hospitalService.getHospitalById(id);
		
		if(hospital.isPresent())
		{
			return new ResponseEntity<Hospital>(hospital.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Hospital>addHospital(@RequestBody Hospital hospital)
	{
		Hospital createhospital = hospitalService.addHospital(hospital);
		return new ResponseEntity<Hospital>(createhospital, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Hospital> updatedHospital(@PathVariable Long hospotalId, @RequestBody Hospital hospitalDetails)
	{
		Optional<Hospital> updatingDetails = hospitalService.getHospitalById(hospotalId);
		if(updatingDetails.isPresent())
		{
			return new ResponseEntity<Hospital>( HttpStatus.OK);
			
		}
		
		else
			return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/{hospitalId}")
	public ResponseEntity<String> deleteHospitalById( @PathVariable Long hospitalId)
	{
		
		Optional<Hospital> hospitalOptional = hospitalService.getHospitalById(hospitalId);
		if(hospitalOptional.isPresent())
		{
			hospitalService.deleteHospitalById(hospitalId);
			return new ResponseEntity<String>("Id Deleted Successfully", HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<String>("Id is not found", HttpStatus.NOT_FOUND);
		}
		
	}
	
		
	}
	

