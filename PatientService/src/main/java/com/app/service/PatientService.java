package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Patient;
import com.app.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAllPatients()
	{
		return patientRepository.findAll();
		
	}
	
	public Optional<Patient> getPatientById(Long id)
	{
		return patientRepository.findById(id);
		
	}
	
	public Patient addPatient(Patient patient)
	{
		return patientRepository.save(patient);
		
	}

	public Patient updatePatient(Long patientId, Patient patientDetails)
	{
		Patient patient = patientRepository.findById(patientId).orElseThrow(()->new RuntimeException("Id was not found"));
		
		patient.setPatientAddress(patientDetails.getPatientAddress());
        patient.setPatientMobNo(patientDetails.getPatientMobNo());
        patient.setPatientName(patientDetails.getPatientName());
		return patientRepository.save(patient);
		
	}
	
	public void deletePatientById(Long id)
	{
		patientRepository.deleteById(id);
	}
	
	
}
