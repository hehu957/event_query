package com.zhrj.exam.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.With;

import java.io.Serializable;

/**
 * zhrj_alarm_info : 事件表
 *
 * @author zhrj
 * @since 2023-03-14
 */
@Data
@TableName("zhrj_alarm_info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZhrjAlarmInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    @TableId
    private Long id;

    // 部门ID
    @ExcelIgnore
    private Long deptId;

    // 终端IP
    @ExcelProperty("终端IP")
    private String wanIp;

    // 采集时间
    @ExcelProperty("采集时间")
    @ColumnWidth(20)
    private String eventTime;

    // 事件类型(DICT: event_type)
    @ExcelProperty("事件类型")
    private Integer eventType;

    // 事件状态(DICT: event_status)
    @ExcelProperty("事件状态")
    private Integer eventStatus;

    // 事件归集原因
    @ExcelProperty("事件原因")
    @ColumnWidth(50)
    private String eventReasons;

}
