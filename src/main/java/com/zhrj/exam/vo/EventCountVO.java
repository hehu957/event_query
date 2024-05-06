package com.zhrj.exam.vo;

import com.zhrj.exam.dto.DeptEvent;
import com.zhrj.exam.dto.TypeEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventCountVO {
    /**
     * 不同部门统计数量结果
     */
    private ArrayList<DeptEvent> deptEventArrayList = new ArrayList<>();


    /**
     * 不同类型统计数量结果
     */
    private ArrayList<TypeEvent> typeEventArrayList = new ArrayList<>();

}
