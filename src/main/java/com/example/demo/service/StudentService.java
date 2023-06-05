package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;

@Service
public class StudentService {
	private static Map<Long, Student> studentsList = new HashMap<>();
	
	public ResponseEntity<Student> getStudentById(Long id) {
		Student student = studentsList.get(id);
		
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = new ArrayList<>(studentsList.values());
		
		return ResponseEntity.status(HttpStatus.OK).body(students);
	}
	
	public ResponseEntity<Student> addStudent(Student newStudent) {
		Student student = studentsList.get(newStudent.getId());
		if (student != null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		studentsList.put(newStudent.getId(), student);
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}
	
	public ResponseEntity<Student> updateStudent(Student newStudent) {
		Student student = studentsList.get(newStudent.getId());
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		studentsList.put(newStudent.getId(), student);
		return ResponseEntity.status(HttpStatus.OK).body(newStudent);
	}
	
	public ResponseEntity<String> deleteStudent(Long id) {
		Student student = studentsList.get(id);
		if (student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		studentsList.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body("Student succesfully deleted");
	}
}
