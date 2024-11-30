package com.raja.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raja.rest.exception.EmployeeNotFoundException;
import com.raja.rest.models.Employee;
import com.raja.rest.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class EmployeeController 
{
	@Autowired
	 EmployeeService employeeService;
	
	@PostMapping("/saveemp")
	public Employee saveEmployee(@RequestBody  @Valid Employee employee)
	{
		     Employee emp=employeeService.save(employee);
		     return emp;
		     
		    		               		
	}
	
	
	@PostMapping("/saveall")
	public ResponseEntity<List<Employee>>saveallEmployee(@RequestBody  List<Employee> employees)
	{
		
		List<Employee> emps =employeeService.saveAllEmployees(employees);
		 return ResponseEntity.status(HttpStatus.CREATED)
				              .header("employees","save successful")
				              .body(emps);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> emps=employeeService.getAllEmployee();
		 return ResponseEntity.status(HttpStatus.OK)
				               .header("status", "data saved successful")
				               .body(emps);
		
		
	}
	
	/*@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id)
	
	{
		Optional<Employee> optionalEmp=employeeService.getById(id);
		if(optionalEmp.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK)
					             .body(optionalEmp.get());
		}
		else
		{
			
			//return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                        // .body("not found ..+id");
			throw new EmployeeNotFoundException("Employee not Found with id"+id);
		}
		
	}*/
	
	
	
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id)
	{	Optional<Employee> optionalEmp = employeeService.getById(id);
		if(optionalEmp.isPresent())
		{	
			Employee employee = optionalEmp.get();
			 // Create an EntityModel for the user
	        EntityModel<Employee> entityModel = EntityModel.of(employee);

	        // Add self link
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getById(id)).withSelfRel());

	        // Add link to update the user
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).updateById(id, employee)).withRel("update"));

	        // Add link to delete the user
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).deleteEmployeeById(id)).withRel("delete"));

	        // Add link to get all users
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getAllEmployees()).withRel("all-users"));
			
			return ResponseEntity.status(HttpStatus.OK)
								 .body(entityModel);
		}
		else
		{	//return ResponseEntity.status(HttpStatus.NOT_FOUND)
				//				 .body("Emp is not found with Id.."+id);	
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
	}
	
	@GetMapping("/getbyemail/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable String email)
	{
		Optional<Employee> optionalEmp=employeeService.getByEmail(email);
		if(optionalEmp.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK)
					             .body(optionalEmp.get());
		}
		else
		{
			
			//return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                        // .body("not found ..+email");
			throw new EmployeeNotFoundException("Employee not Found with email"+email);
		}
		
	}
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id)
	{
		boolean status =employeeService.deleteEmployeeById(id);
		if(status)
		{
			return ResponseEntity.noContent().build();
			
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .header("status", "id is not present")
					             .body("id is not found...."+id);
		}
	}
	
	@DeleteMapping("/deletebyemail/{email}")
	public ResponseEntity<?> deleteByEmail(@PathVariable String email)
	{
		 boolean status = employeeService.deleteByEmail(email);
		 if(status)
		 {
			 
			 return ResponseEntity.noContent().build();
					              
		          
		 }
       else
         {

             return ResponseEntity.status(HttpStatus.NOT_FOUND)
            		              
                                  .body("not found ..+email");

		 }
	}
	
	
	
	/*@DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllEmployees() 
	{
        boolean status = employeeService.deleteAllEmployees();
        if (status)
        {
            return ResponseEntity.noContent().build();
        } 
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Status", "Error occurred while deleting employees")
                    .body("Failed to delete all employees.");
        }
    }*/
	
	@DeleteMapping("/deleteall")
	public void deleteAll()
	{
		employeeService.deleteAll();
		
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@PathVariable  Long id ,@RequestBody Employee newemployee)
	{
		 Optional<Employee> updateemp = employeeService.updateByid(id,newemployee);
		 if(updateemp.isPresent())
		 {
			 
			 return ResponseEntity.status(HttpStatus.OK)
					               .header(" success", "successful update")
					               .body(updateemp);
					              
		          
		 }
       else
         {

             return ResponseEntity.status(HttpStatus.NOT_FOUND)
            		              
                                  .body("not found ..");

		 }
	}
	
	
	@PatchMapping("/update/{id}")
	 
	 public ResponseEntity<?> updateEmploye(@PathVariable Long id,@RequestBody Map<String,Object> updates){
		 
		 Optional<Employee> emps = employeeService.updateEmploye(id,updates);
		 
		 if(emps.isPresent()) {
			 
			 return ResponseEntity.status(HttpStatus.OK)
		              .body(emps);
		 }
		 
		 else {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
		              .header("status", "status not updated ")
		              .body("id is not found "+id);
			 
		 }
	 }
	
	@GetMapping("/getnames")
	public List<String> getNames()
	{
		
		return employeeService.getNames();
		//return List.of("raja","sekhar","kali");
	}
	
	
	

}
