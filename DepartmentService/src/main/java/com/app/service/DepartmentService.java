package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	
	@Autowired
	public DepartmentRepository departmentRpoRepository;
	
	public Department saveDepartment(Department department)
	{
		return departmentRpoRepository.save(department);
		
	}
	
	public Department getDepartmentById(Long id)
	{
		return departmentRpoRepository.findById(id).get();
		
	}

}
