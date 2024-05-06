package com.zhrj.exam.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * zhrj_menu : 菜单表
 *
 * @author zhrj
 * @since 2023-03-14
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@TableName("zhrj_menu")
public class ZhrjMenu implements Serializable {

    // 菜单名称
    @TableId
    private String menuName;

    // 实际值
//    @TableId
    private Integer actualValue;

    // 显示值
    private String displayValue;

    // 菜单描述
    private String menuDescription;

}
