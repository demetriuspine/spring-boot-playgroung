package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private Long id;
	private String name;
	private String email;
	private LocalDate birthDate;
}
