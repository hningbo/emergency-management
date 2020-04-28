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
import java.util.List;

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
        System.out.println(studentRepository.findAll(pageable));
        return studentRepository.findAll(pageable);
    }

    @Override
    public void CreateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void edit(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudent(String sID) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return studentRepository.findAllBySIDContaining(sID,sort);
    }
}
