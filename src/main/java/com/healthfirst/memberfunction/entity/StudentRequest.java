package com.healthfirst.memberfunction.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
	private String studentId;
	private String lastName;
	private int age;
}
