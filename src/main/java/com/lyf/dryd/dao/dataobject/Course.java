package com.lyf.dryd.dao.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date gmtCreate;
    private Boolean deleted;
    private String name;
    private String type;
    private Date startTime;
    private Integer length;
    private Long areaId;
    private String areaName;
    private String introduction;
    private Long userId;
    private Integer status;

}
