package com.raja.rest.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.raja.rest.models.Hospital;
import com.raja.rest.repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital save(Hospital hospital)
	{
		Hospital hosp=hospitalRepository.save(hospital);
		return hosp;
	}
	
		
	
	public List<Hospital> saveAllHospital(List<Hospital> hospital) 
	{
		List<Hospital> hosp=hospitalRepository.saveAll(hospital);
		return hosp;
		
		
	}


     
	public List<Hospital> getAllHospital() 
	{
		List<Hospital> hosp=hospitalRepository.findAll();
		return hosp;
	}






    
	public Optional<Hospital> getById(Long id)
	{
		Optional<Hospital> hosp=hospitalRepository.findById(id);
		return hosp;
	}


    
	public Optional<Hospital> getBySpecialization(String specialization) 
	{
		
		Optional<Hospital> hosp=hospitalRepository.findBySpecialization(specialization);
		return hosp;
	}


    
	public boolean deleteByHospitalId(Long id) 
	{
		   boolean status =hospitalRepository.existsById(id);
           if(status)
           {
        	   return true;
        	   
           }
           else
           {
        	   return false;
           }
	}


	public boolean deleteBySpecialization(String specialization)
	{

		 boolean status=hospitalRepository.existsBySpecialization(specialization);
		 if(status)
		 {
			 return true;
			 
		 }
		 else
		 {
			 return false;
		 }
	}



	public Optional<Hospital> updateByid(Long id, Hospital newhospital) 
	{
		
         Optional<Hospital> optionalhosp=hospitalRepository.findById(id);
		
		if(optionalhosp.isPresent())
		{
			Hospital existingHospital=optionalhosp.get();
			existingHospital.setName(newhospital.getName());
			existingHospital.setMobile(newhospital.getMobile());
			existingHospital.setRating(newhospital.getRating());
			existingHospital.setAddress(newhospital.getAddress());
			existingHospital.setSpecialization(newhospital.getSpecialization());
			
			Hospital updateHospital=hospitalRepository.save(existingHospital);
			return Optional.of(updateHospital);
			
			
		}
		else
		{
			return optionalhosp.empty();
		
	}
	
	 
	

}



	public Optional<Hospital> updateHospital(Long id, Map<String, Object> updates)
	{
		 Optional<Hospital> optionalhosp = hospitalRepository.findById(id);

		  
		    if (optionalhosp.isPresent()) {
		        Hospital existingData = optionalhosp.get();

		        updates.forEach((key, value) -> {
		            switch (key) {
		                case "name":
		                    existingData.setName((String) value);
		                    break;
		                case "specilization":
		                    existingData.setSpecialization((String) value);
		                    break;
		                case "mobile":
		                    existingData.setMobile((Long) value);
		                    break;
		                case "address":
		                    existingData.setAddress((String) value);
		                    break;
		                case "rating":
		                    existingData.setRating((int) value);
		                    break;
		               
		            }
		        });

		        // Save the updated employee data to the database
		        hospitalRepository.save(existingData);

		        return Optional.of(existingData);
		        
		    } 
		    
		    else {
		        // If employee not found, return Optional.empty()
		        return Optional.empty();
		    }
	}
}
