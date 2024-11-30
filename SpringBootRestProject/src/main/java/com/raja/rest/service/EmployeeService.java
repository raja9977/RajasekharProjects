package com.raja.rest.service;



import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raja.rest.entity.EmployeeEntity;
import com.raja.rest.model.EmployeeModel;
import com.raja.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository  employeeRepository;

	public EmployeeEntity saveEmp(EmployeeModel model) {
		
		EmployeeEntity entity = new EmployeeEntity();

        // Set the fields from model to entity
        entity.setEmpName(model.getEmpName());
        entity.setBasicsalary(model.getBasicsalary());
        entity.setEmpDept(model.getEmpDept());
        entity.setEmpEmail(model.getEmpEmail());
        entity.setEmpMobile(model.getEmpMobile());

        // Calculate derived fields (like hra, da, pf, and totalSalary)
        double hra = model.getBasicsalary() * 0.10; // Example calculation
        double da = model.getBasicsalary() * 0.05;  // Example calculation
        double pf = model.getBasicsalary() * 0.12;  // Example calculation
        double totalSalary = model.getBasicsalary() + hra + da - pf;

        entity.setHra(hra);
        entity.setDa(da);
        entity.setPf(pf);
        entity.setTotalsalary(totalSalary);

        // Set other fields like joinDate if applicable
        entity.setJoiningDate(LocalDate.now());
       
         return  employeeRepository.save(entity);
         
		
	}
	

}

		
	

		
		

