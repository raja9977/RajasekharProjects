package com.raja.rest.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.raja.rest.models.Hospital;
import com.raja.rest.service.HospitalService;

@RestController
@RequestMapping("/api/v1")
public class HospitalController 
{
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/savehospital")
	public Hospital saveHospital(@RequestBody Hospital hospital)
	{
		
		 Hospital hosp=hospitalService.save(hospital);
		 return hosp;
	}
	
	
	@PostMapping("/saveall")
	public ResponseEntity<List<Hospital>>saveallHospital(@RequestBody List<Hospital> hospital)
	{
		List<Hospital> hosp=hospitalService.saveAllHospital(hospital);
		return ResponseEntity.status(HttpStatus.CREATED)
				              .header("hospital", "successful is saved")
				             .body(hosp);
		
		
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<Hospital>> getAllHospital()
	{
		List<Hospital> hosp=hospitalService.getAllHospital();
		 return ResponseEntity.status(HttpStatus.OK)
				               .header("status", "data saved successful")
				               .body(hosp);
		
		
	}
	
	
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id)
	
	{
		Optional<Hospital> optionalhosp=hospitalService.getById(id);
		if(optionalhosp.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK)
					             .body(optionalhosp.get());
		}
		else
		{
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                         .body("not found ..+id");
		}
	
		
	}
	
	
     @GetMapping("/getbyspecialization/{specialization}")
	public ResponseEntity<?> getBySpecialization(@PathVariable String specialization)
	{
		
    	 Optional<Hospital> optionalhosp=hospitalService.getBySpecialization(specialization);
    	 if(optionalhosp.isPresent())
    	 {
    		 return ResponseEntity.status(HttpStatus.OK)
    				              .body(optionalhosp.get());    	 
	    }
     else
     {
    	 return ResponseEntity.status(HttpStatus.NOT_FOUND)
    			               .body("not found"+specialization);
     }
	}
     
     
     @DeleteMapping("/deletebyid/{id}")
 	public ResponseEntity<?> deleteByHospitalId(@PathVariable Long id)
 	{
 		boolean status =hospitalService.deleteByHospitalId(id);
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
 	
     
 	@DeleteMapping("/deletebyspecialization/{specialization}")
 	public ResponseEntity<?> deleteBySpecialization(@PathVariable String specialization)
 	{
 		 boolean status = hospitalService.deleteBySpecialization(specialization);
 		 if(status)
 		 {
 			 
 			 return ResponseEntity.noContent().build();
 					              
 		          
 		 }
        else
          {

              return ResponseEntity.status(HttpStatus.NOT_FOUND)
             		              
                                   .body("not found ..+specializaton");

 		 }
 	}
 	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@PathVariable  Long id ,@RequestBody Hospital newhospital)
	{
		 Optional<Hospital> updatehosp = hospitalService.updateByid(id,newhospital);
		 if(updatehosp.isPresent())
		 {
			 
			 return ResponseEntity.status(HttpStatus.OK)
					               .header(" success", "successful update")
					               .body(updatehosp);
					              
		          
		 }
       else
         {

             return ResponseEntity.status(HttpStatus.NOT_FOUND)
            		              
                                  .body("not found ..");

		 }
	}
	
	
	@PatchMapping("/update/{id}")
	 
	 public ResponseEntity<?> updateHospital(@PathVariable Long id,@RequestBody Map<String,Object> updates){
		 
		 Optional<Hospital> hosp= hospitalService.updateHospital(id,updates);
		 
		 if(hosp.isPresent()) {
			 
			 return ResponseEntity.status(HttpStatus.OK)
		              .body(hosp);
		 }
		 
		 else {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
		              .header("status", "status not updated ")
		              .body("id is not found "+id);
			 
		 }
	 }

	
	


}
	
	
	
	
	
	


