package com.ningyuanlong.Repository;

import com.ningyuanlong.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tony on 2020/4/25.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
