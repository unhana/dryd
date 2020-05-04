package com.lyf.dryd.service.user;

import com.lyf.dryd.dao.dataobject.Course;
import com.lyf.dryd.dao.dataobject.User;
import com.lyf.dryd.dao.repository.CourseRepository;
import com.lyf.dryd.dao.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CourseService {
    @Resource
    private CourseRepository courseRepository;

    public boolean save(Course course){
        course.setDeleted(false);
        course.setGmtCreate(new Date());
        courseRepository.save(course);
        return course.getId() != null;
    }
}
