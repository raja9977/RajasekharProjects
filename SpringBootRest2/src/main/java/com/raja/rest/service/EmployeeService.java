package com.raja.rest.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.raja.rest.models.Employee;
import com.raja.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee save(Employee employee) 
	{
		Employee emp=employeeRepository.save(employee);
		return emp;
		
		
	}



	public List<Employee> saveAllEmployees(List<Employee> employees) 
	{
	    
		List<Employee> employee= employeeRepository.saveAll(employees);
		return employee;
		
	}



	public List<Employee> getAllEmployee() {
		   
		 List<Employee> emps=employeeRepository.findAll();
		  return emps;
		
	
	}



	public Optional<Employee> getById(Long id) {
		
		Optional<Employee> optionalemp=employeeRepository.findById(id);
		return optionalemp;
		
	
	}



	public Optional <Employee> getByEmail( String email) {
		Optional<Employee> optionalemp=employeeRepository.findByEmail(email);
		return optionalemp;
		
		
		
	}



	public boolean deleteEmployeeById(Long id) 
	{
	           boolean status =employeeRepository.existsById(id);
	           if(status)
	           {
	        	   return true;
	        	   
	           }
	           else
	           {
	        	   return false;
	           }
	           
	}

	public boolean deleteByEmail(String email) 
	{
		

		 boolean status=employeeRepository.existsByEmail(email);
		 if(status)
		 {
			 return true;
			 
		 }
		 else
		 {
			 return false;
		 }
		
	}



	/*public boolean deleteAllEmployees() 
	{
		
			 long count = employeeRepository.count(); // Check if any employees exist
			    if (count > 0) 
			    {
			        employeeRepository.deleteAll(); // Delete all employees
			        return true;
			    }  
			    else 
			    {
			        return false; // Return false if no employees to delete
			    }
		}*/



	public void deleteAll() 
	{
		employeeRepository.deleteAll();
		
		
	}



	public Optional<Employee> updateByid(Long id, Employee newemployee)
	{
		 
		Optional<Employee> optionalemp=employeeRepository.findById(id);
		
		if(optionalemp.isPresent())
		{
			Employee existingEmployee=optionalemp.get();
			existingEmployee.setName(newemployee.getName());
			existingEmployee.setSalary(newemployee.getSalary());
			existingEmployee.setDepartment(newemployee.getDepartment());
			existingEmployee.setAddress(newemployee.getAddress());
			existingEmployee.setEmail(newemployee.getEmail());
			
			Employee updateEmployee=employeeRepository.save(existingEmployee);
			return Optional.of(updateEmployee);
			
			
		}
		else
		{
			return optionalemp.empty();
		}

	}



	public Optional<Employee> updateEmploye(Long id, Map<String, Object> updates) 
	{
			   
		    Optional<Employee> optionalEmp = employeeRepository.findById(id);

		  
		    if (optionalEmp.isPresent()) {
		        Employee existingData = optionalEmp.get();

		        updates.forEach((key, value) -> {
		            switch (key) {
		                case "name":
		                    existingData.setName((String) value);
		                    break;
		                case "department":
		                    existingData.setDepartment((String) value);
		                    break;
		                case "salary":
		                    existingData.setSalary((Double) value);
		                    break;
		                case "address":
		                    existingData.setAddress((String) value);
		                    break;
		                case "email":
		                    existingData.setEmail((String) value);
		                    break;
		               
		            }
		        });

		        // Save the updated employee data to the database
		        employeeRepository.save(existingData);

		        return Optional.of(existingData);
		        
		    } 
		    
		    else {
		        // If employee not found, return Optional.empty()
		        return Optional.empty();
		    }
		    
		    
		}
	
	
	@Cacheable("names")
	public List<String> getNames()
	{
		System.out.println("fetching names");
		 return List.of("raja","kiram","kalam");
	}
	}
		

	
	
	


