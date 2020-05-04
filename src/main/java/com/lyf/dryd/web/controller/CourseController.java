package com.lyf.dryd.web.controller;

import com.lyf.dryd.common.enums.ErrorMessage;
import com.lyf.dryd.dao.dataobject.Course;
import com.lyf.dryd.service.user.CourseService;
import com.lyf.dryd.service.user.UserService;
import com.lyf.dryd.web.dataobject.CourseReq;
import com.lyf.dryd.web.dataobject.UserReq;
import com.lyf.dryd.web.utils.ViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(path = "save")
    public ViewResult save(@RequestBody CourseReq course){
        Course courseSave = Course.builder()
                .name(course.getName())
                .type(course.getType())
                .status(course.getStatus())
                .build();
        boolean success = courseService.save(courseSave);
        if(success){
            return ViewResult.success();
        } else {
            return ViewResult.fail(ErrorMessage.USER_CAN_NOT_EMPTY.getCode(),ErrorMessage.USER_CAN_NOT_EMPTY.getMsg());
        }
    }

}
