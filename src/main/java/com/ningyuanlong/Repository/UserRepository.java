package com.ningyuanlong.Repository;

import com.ningyuanlong.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tony on 2020/4/25.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
