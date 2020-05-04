package com.lyf.dryd.web.controller;

import com.lyf.dryd.common.dataobject.UserInfoVO;
import com.lyf.dryd.common.enums.AccountType;
import com.lyf.dryd.common.enums.ErrorMessage;
import com.lyf.dryd.common.utils.AssertUtil;
import com.lyf.dryd.common.utils.UserUtils;
import com.lyf.dryd.dao.dataobject.User;
import com.lyf.dryd.service.user.UserService;
import com.lyf.dryd.web.dataobject.UserReq;
import com.lyf.dryd.web.utils.ViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(path = "register")
    public ViewResult register(@RequestBody UserReq user){
        AssertUtil.checkNull(user, ErrorMessage.USER_CAN_NOT_EMPTY);
        AssertUtil.checkNull(user.getUserName(),ErrorMessage.PARAM_NOT_EMPTY, "用户名");
        AssertUtil.checkNull(user.getPassword(), ErrorMessage.PARAM_NOT_EMPTY, "密码");
        AssertUtil.checkNull(AccountType.valueByMappingValue(Integer.valueOf(user.getType())), ErrorMessage.PARAM_FAIL, "账号类型");

        User userDo = userService.findByUserName(user.getUserName());
        AssertUtil.checkTrue(userDo != null, ErrorMessage.USER_ALREADY_EXISTS,user.getUserName());
        userDo = User.builder()
                .accountType(Integer.valueOf(user.getType()))
                .username(user.getUserName())
                .password(user.getPassword())
                .build();

        boolean success = userService.save(userDo);
        if(success){
            return ViewResult.success();
        } else {
            return ViewResult.fail(ErrorMessage.USER_CAN_NOT_EMPTY.getCode(),ErrorMessage.USER_CAN_NOT_EMPTY.getMsg());
        }
    }

    @ResponseBody
    @PostMapping(path = "login")
    public ViewResult login(@RequestBody UserReq user, HttpServletResponse response, HttpSession session){
        AssertUtil.checkNull(user, ErrorMessage.USER_CAN_NOT_EMPTY);
        AssertUtil.checkNull(user.getUserName(), ErrorMessage.PARAM_NOT_EMPTY,"用户名");
        AssertUtil.checkNull(user.getPassword(), ErrorMessage.PARAM_NOT_EMPTY,"密码");

        User userDO = userService.findByUserName(user.getUserName());
        AssertUtil.checkNull(userDO, ErrorMessage.USER_NOT_EXISTS);
        UserInfoVO userInfoVO = UserInfoVO.builder()
                .userName(userDO.getUsername())
                .id(userDO.getId())
                .accountType(AccountType.valueByMappingValue(userDO.getAccountType()))
                .build();

        session.setAttribute("userInfo", userInfoVO);
        String sessionId = UserUtils.saveToCache(userInfoVO);
        Cookie cookie = new Cookie("sessionId", sessionId);
        cookie.setPath("/");
        Cookie accountType = new Cookie("accountType", AccountType.valueByMappingValue(userDO.getAccountType()).getCode());
        accountType.setPath("/");

        response.addCookie(cookie);
        response.addCookie(accountType);
        return ViewResult.success(sessionId);
    }

    @PostMapping(path = "logout")
    public ViewResult logout(HttpServletResponse response){
        Cookie cookie = new Cookie("sessionId", "");
        response.addCookie(cookie);
        return ViewResult.success();
    }
}
