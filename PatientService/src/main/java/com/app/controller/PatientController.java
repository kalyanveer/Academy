package com.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.app.entity.Patient;
import com.app.service.PatientService;

@RestController
@RequestMapping
public class PatientController {
	
	
	@Autowired
	private PatientService patientService;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Patient>>getAllPatientients()
	{
		List<Patient> patientsList = patientService.getAllPatients();
		return new ResponseEntity<List<Patient>>(patientsList, HttpStatus.OK);
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Patient> getPatientsById(@PathVariable Long id)
	{
		Optional<Patient> patientId = patientService.getPatientById(id);
		
		if(patientId.isPresent())
		{
			return new ResponseEntity<Patient>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient( @PathVariable Long PatientId,@RequestBody Patient patient)
	{
		
		Optional<Patient> updatedDetails = patientService.getPatientById(PatientId);
		if(updatedDetails.isPresent())
		{
			return new ResponseEntity<Patient>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Patient>( HttpStatus.NOT_FOUND);
		
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePatientById(@PathVariable Long id)
	{
		Optional<Patient> OptionalPatient = patientService.getPatientById(id);
		
		if(OptionalPatient.isPresent())
		{
			return new ResponseEntity<String>("Id deleted Successfully", HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<String>("Id is Not found", HttpStatus.NOT_FOUND);
		}
			
	}
	
	
	@PostMapping
	public ResponseEntity<Patient> addPatient(Patient patientt)
	
	{
    Patient createPatient = patientService.addPatient(patientt);
     return new ResponseEntity<Patient>(createPatient, HttpStatus.CREATED);
		
	}
		
		
	
	
	
	
	
}
