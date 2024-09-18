package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Hospital;
import com.app.repository.HospitalRepository;


@Service
public class HospitalService {
	
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> getAllHospitals(){
		return hospitalRepository.findAll();
		
	}
	
	public Optional<Hospital> getHospitalById(Long id)
	{
		return hospitalRepository.findById(id);
		
	}
	
	public Hospital addHospital(Hospital hospital)
	{
		return hospitalRepository.save(hospital);
		
	}
	

	
   public Hospital updateHospital(Long hospitalId,Hospital hospitalDetails)
   {
	   Hospital hospital= hospitalRepository.findById(hospitalId).orElseThrow(()->new RuntimeException("HospitalId No found"));
	    hospital.setHospitalName(hospitalDetails.getHospitalName());
	    hospital.setPhoneNumber(hospitalDetails.getPhoneNumber());
	    hospital.setHospitalAddress(hospitalDetails.getHospitalAddress());
	   return hospitalRepository.save(hospital);
	   
   }
	public void deleteHospitalById(Long id)
	{
		 hospitalRepository.deleteById(id);
	}
	
	
	
	
	
	/*
	 * public List<Hospital> getAlll() { return hospitalRepository.findAll();
	 * 
	 * }
	 * 
	 * public Optional<Hospital> getHospitalById1(Long id) { return
	 * hospitalRepository.findById(id);
	 * 
	 * }
	 * 
	 * public Hospital updateHospital1(Long hospitalId, Hospital hospitalDetails1) {
	 * Hospital updatedDetails1 =
	 * hospitalRepository.findById(hospitalId).orElseThrow(()->new
	 * RuntimeException("Id is Not Found"));
	 * updatedDetails1.setHospitalAddress(hospitalDetails1.getHospitalAddress());
	 * updatedDetails1.setHospitalName(hospitalDetails1.getHospitalName());
	 * updatedDetails1.setPhoneNumber(hospitalDetails1.getPhoneNumber()); return
	 * hospitalDetails1;
	 * 
	 * }
	 * 
	 * public void deleteById(Long id) { hospitalRepository.deleteById(id); }
	 * 
	 * public Hospital addsHospital(Hospital hospital) { return
	 * hospitalRepository.save(hospital);
	 * 
	 * }
	 */
	
}



