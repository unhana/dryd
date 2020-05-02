package com.lyf.dryd.web.controller;

import com.lyf.dryd.web.dataobject.UserReq;
import com.lyf.dryd.web.utils.ViewResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {



    @ResponseBody
    @PostMapping(path = "register")
    public ViewResult register(@RequestBody UserReq user){

        return ViewResult.success();
    }

    @ResponseBody
    @PostMapping(path = "login")
    public String login(@RequestBody UserReq user){
        return user.getPassword() + user.getUserName();
    }
}