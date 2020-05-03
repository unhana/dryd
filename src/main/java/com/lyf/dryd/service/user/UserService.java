package com.lyf.dryd.service.user;

import com.lyf.dryd.dao.dataobject.User;
import com.lyf.dryd.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findByUserName(String userName){
        return userRepository.findOneByUsername(userName);
    }
}
