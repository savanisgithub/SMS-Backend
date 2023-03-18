package com.SNNaotunna.StudentManagementSystem.repository;

import com.SNNaotunna.StudentManagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
