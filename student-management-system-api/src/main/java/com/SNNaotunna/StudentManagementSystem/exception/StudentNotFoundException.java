package com.SNNaotunna.StudentManagementSystem.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id){
        super("Could not found the user " + id);
    }
}