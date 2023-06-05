package com.example.demo.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Student {
	private Long id;
	private String name;
	private String email;
	private LocalDate birthDate;
}
