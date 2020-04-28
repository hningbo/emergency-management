package com.ningyuanlong.service.Impl;

import com.ningyuanlong.Repository.StudentRepository;
import com.ningyuanlong.domain.Student;
import com.ningyuanlong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Tony on 2020/4/25.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Resource
    private StudentRepository studentRepository;

    @Override
    public Page<Student> findStudentCriteria(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return studentRepository.findAll(pageable);
    }
}
