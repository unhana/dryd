package com.lyf.dryd.dao.repository;

import com.lyf.dryd.dao.dataobject.Course;
import com.lyf.dryd.dao.dataobject.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query(value = "select * from course where type = ?1 and deleted=0", nativeQuery = true)
    Course findCourseByType(String type);
}
