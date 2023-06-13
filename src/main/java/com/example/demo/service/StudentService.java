package com.example.demo.service;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	private StudentRepository studentRepository;
	
	public ResponseEntity<Student> getStudentById(Long id) {
		if (!studentRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findById(id).get());
	}
	
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
	}
	
	public ResponseEntity<Student> addStudent(Student newStudent) {
		Student createdStudent = studentRepository.save(newStudent);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	}
	
	public ResponseEntity<Student> updateStudent(Long id, Student newStudent) {
		if (!studentRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		Student updatedStudent = studentRepository.save(newStudent);
		return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
	}
	
	public ResponseEntity<String> deleteStudent(Long id) {
		if (!studentRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		studentRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Student succesfully deleted");
	}
}
