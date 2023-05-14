package com.springjpahibernate.demo;

import com.springjpahibernate.demo.dao.StudentDao;
import com.springjpahibernate.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
			//createStudent(studentDao);
			//readStudent(studentDao);
			//fetchAllStudents(studentDao);
			//fetchStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudentById(studentDao);
			//deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		int count = studentDao.deleteAll();
		System.out.println("All students deleted:"+count);
	}

	private void deleteStudentById(StudentDao studentDao) {
		Integer studentId = 2;
		studentDao.delete(studentId);
		System.out.println("Student deleted from db");
	}

	private void updateStudent(StudentDao studentDao) {
		//fetch the student with the given id
		int studentId = 1;
		Student student = studentDao.findById(studentId);
		//change the last Name for the fetched student
		student.setFirstName("Array");
		//update the student
		studentDao.update(student);
		//display the updated student
		System.out.println(student);
	}

	private void fetchStudentsByLastName(StudentDao studentDao) {
		List<Student> studentList = studentDao.findByLastName("jane");
		for (Student student: studentList
		) {
			System.out.println(student);
		}
	}

	private void fetchAllStudents(StudentDao studentDao) {
		List<Student> studentList =
			studentDao.findAll();
		for (Student student: studentList
			 ) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDao studentDao) {
		//create one student first which could be available to read
		System.out.println(studentDao.findById(2));
	}

	private void createStudent(StudentDao studentDao) {
		//create the student object
		Student student1 =
			new Student("john","doe","xyz@gmail.com");
		Student student2 =
			new Student("akash","jane","yz@gmail.com");
		Student student3 =
			new Student("vikky","hash","yz@gmail.com");
		Student student4 =
			new Student("linked","list","linkedlist@gmail.com");
		//save the student object
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
		studentDao.save(student4);
		//display id of the saved student
	}
}
