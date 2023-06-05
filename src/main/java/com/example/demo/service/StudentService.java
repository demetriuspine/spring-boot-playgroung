package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Student;

public class StudentService {
	private static Map<Long, Student> studentsList = new HashMap<>();
	
	private ResponseEntity<Student> getStudentById(Long id) {
		Student student = studentsList.get(id);
		
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	private List<Student> getStudents() {
		List<Student> students = new ArrayList<>(studentsList.values());
		
		return students;
	}
}
