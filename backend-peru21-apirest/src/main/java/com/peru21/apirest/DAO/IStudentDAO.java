package com.peru21.apirest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.peru21.apirest.entities.Student;

public interface IStudentDAO extends JpaRepository<Student, Long> {

}
