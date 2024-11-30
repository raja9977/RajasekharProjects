package com.raja.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raja.rest.models.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> 
{
	Optional<Hospital> findBySpecialization(String specialization);
     
	boolean existsBySpecialization(String specialization);
	void deleteBySpecialization(String specialization);

}
