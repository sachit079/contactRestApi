package com.skn.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(name="Mobile Number")
	private Long mobNo;
	@Column(name="Address")
	private String addr;
	@Column(name="Reltion")
	private String rel;
	@Column(name="Date_Of_Birth")
	private String Dob;
	private String email;
	private Boolean nri;
	@CreationTimestamp
	@Column(name="Created_Time" ,updatable=false)
	private LocalDate createTime;
	@Column(name="Updated_Time" ,insertable=false)
	private LocalDate updateTime;
	
}
