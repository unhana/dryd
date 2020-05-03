package com.lyf.dryd.dao.repository;

import com.lyf.dryd.dao.dataobject.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {


    @Query(value = "select * from user where username = ?1 and deleted=0", nativeQuery = true)
    User findOneByUsername(String name);
}
