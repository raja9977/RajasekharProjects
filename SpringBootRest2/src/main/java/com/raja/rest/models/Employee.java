package com.raja.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	
	
	 @NotNull(message = "ID cannot be null")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary must be a positive value")
    private Double salary;

    @NotBlank(message = "Department cannot be empty")
    @Size(min = 1, max = 50, message = "Department must be between 1 and 50 characters")
    private String department;

    @NotBlank(message = "Address cannot be empty")
    @Size(max = 255, message = "Address must be at most 255 characters")
    private String address; // Note: fixed spelling from 'adress' to 'address'

    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be at most 100 characters")
    private String email;
}
