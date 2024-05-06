package com.zhrj.exam.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * zhrj_dept : 部门表
 *
 * @author zhrj
 * @since 2023-03-14
 */
@Data
@TableName("zhrj_dept")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZhrjDept implements Serializable {

    @TableId
    private Long deptId;

    //父部门id
    private Long parentId;

    // 祖级列表
    private String ancestors;

    // 部门名称
    private String deptName;

    // 部门编号
    private String deptNo;

    // 显示顺序
    private Integer orderNum;

}
