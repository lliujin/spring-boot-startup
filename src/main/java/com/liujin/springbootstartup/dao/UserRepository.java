package com.liujin.springbootstartup.dao;

import com.liujin.springbootstartup.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByIdAndPassword(Long id, String password);
}
