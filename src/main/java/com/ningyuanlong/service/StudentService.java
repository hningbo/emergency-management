package com.ningyuanlong.service;

import com.ningyuanlong.domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Tony on 2020/4/25.
 */
public interface StudentService {
    Page<Student> findStudentCriteria(Integer page, Integer size);

    void CreateStudent(Student student);

    Student findStudentById(Long id);

    void edit(Student student);

    void save(Student student);

    List<Student> getStudent(String sID);
}