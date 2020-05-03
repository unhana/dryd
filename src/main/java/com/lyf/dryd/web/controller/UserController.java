package com.lyf.dryd.web.controller;

import com.lyf.dryd.common.enums.ErrorMessage;
import com.lyf.dryd.common.utils.AssertUtil;
import com.lyf.dryd.dao.dataobject.User;
import com.lyf.dryd.service.user.UserService;
import com.lyf.dryd.web.dataobject.UserReq;
import com.lyf.dryd.web.utils.ViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(path = "register")
    public ViewResult register(@RequestBody UserReq user){
        AssertUtil.checkNull(user, ErrorMessage.USER_CAN_NOT_EMPTY);
        User existsUser = userService.findByUserName(user.getUserName());
        AssertUtil.checkTrue(existsUser == null, ErrorMessage.USER_ALREADY_EXISTS,user.getUserName());
        return ViewResult.success();
    }

    @ResponseBody
    @PostMapping(path = "login")
    public String login(@RequestBody UserReq user){
        return user.getPassword() + user.getUserName();
    }
}
