package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
	
	private StudentService studentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		return studentService.getStudents();
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student newStudent) {
		return studentService.addStudent(newStudent);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
		return studentService.updateStudent(id, newStudent);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
}
