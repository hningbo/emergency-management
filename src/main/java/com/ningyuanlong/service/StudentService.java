package com.ningyuanlong.service;

import com.ningyuanlong.domain.Student;
import org.springframework.data.domain.Page;

/**
 * Created by Tony on 2020/4/25.
 */
public interface StudentService {
    Page<Student> findStudentCriteria(Integer page, Integer size);
}