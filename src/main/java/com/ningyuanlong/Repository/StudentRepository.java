package com.ningyuanlong.Repository;

import com.ningyuanlong.domain.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tony on 2020/4/25.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(Long id);

    List<Student> findAllBySIDContaining(String sID, Sort sort);
}
