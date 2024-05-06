package com.zhrj.exam.vo;

import com.zhrj.exam.dto.DateEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDateCountVO {
    /**
     * 日期分类事件
     */
    private ArrayList<DateEvent> dateEventArrayList;
}
