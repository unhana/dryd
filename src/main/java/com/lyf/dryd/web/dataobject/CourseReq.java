package com.lyf.dryd.web.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseReq {
    private String name;
    private String type;
    private Date startTime;
    private Integer length;
    private Long areaId;
    private String introduction;
    private Long userId;
    private Integer status;
}
