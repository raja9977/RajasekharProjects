package com.raja.rest.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ValueGenerationType;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;
	private String empName;
	private double basicsalary;
	private double hra;
	private double da;
	private double pf;
	private double totalsalary;
	private String empDept;
	private String empEmail;
	private long empMobile;
	private LocalDate joiningDate;
	
	

}
