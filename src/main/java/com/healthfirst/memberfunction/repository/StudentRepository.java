package com.healthfirst.memberfunction.repository;

import com.healthfirst.memberfunction.entity.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface StudentRepository extends CrudRepository<Student, String> {
	//
}
