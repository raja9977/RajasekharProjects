package com.raja.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raja.rest.entity.EmployeeEntity;
import com.raja.rest.model.EmployeeModel;
import com.raja.rest.service.EmployeeService;

import jakarta.persistence.Table;
@Table(name="employee")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController 
{
@Autowired
  EmployeeService employeeService;


@PostMapping("/saveemp")
public EmployeeEntity saveEmployeeEnity(@RequestBody EmployeeModel model ) 
{

	EmployeeEntity employeeEntity=employeeService.saveEmp(model);
			return employeeEntity;
			
}
     


}