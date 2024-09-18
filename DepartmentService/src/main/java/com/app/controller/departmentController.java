package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class departmentController {
	
	
	@Autowired
	public DepartmentService departmentService;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
		
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable long id)
	{
		return departmentService.getDepartmentById(id);
	}
	
	

}
