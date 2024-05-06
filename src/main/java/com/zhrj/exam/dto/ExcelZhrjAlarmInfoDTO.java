package com.zhrj.exam.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zhrj.exam.entity.ZhrjAlarmInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExcelZhrjAlarmInfoDTO extends ZhrjAlarmInfo {

    @ExcelProperty(value = "部门名称",index = 0)
    private String deptName;
}
