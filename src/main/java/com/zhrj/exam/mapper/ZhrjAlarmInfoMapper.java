package com.zhrj.exam.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhrj.exam.dto.DateEvent;
import com.zhrj.exam.dto.DeptEvent;
import com.zhrj.exam.dto.ExcelZhrjAlarmInfoDTO;
import com.zhrj.exam.dto.TypeEvent;
import com.zhrj.exam.entity.ZhrjAlarmInfo;
import com.zhrj.exam.vo.EventDateCountVO;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 事件表 Mapper 接口
 * </p>
 *
 * @author zhrj
 * @since 2023-03-14
 */

public interface ZhrjAlarmInfoMapper extends BaseMapper<ZhrjAlarmInfo> {

    /**
     *
     * @param ZhrjAlarmInfoList 对象集合
     * @return
     */
    boolean saveBatch(@Param("list") Collection<ZhrjAlarmInfo> ZhrjAlarmInfoList);

    /**
     * 查询不同部门维护数量
     * @return
     */
    public ArrayList<DeptEvent> selectAllDeptEvents();

    /**
     * 查询不同事件类型的数量
     * @return
     */
    public ArrayList<TypeEvent> selectAllTypeEvents();


    /**
     * 按时间统计事件数
     * @param date
     * @return
     */
    public ArrayList<DateEvent> selectAllEventsByDate(@Param("date") String date);


    /**
     * 查询所有事件信息
     * @return
     */
    public ArrayList<ExcelZhrjAlarmInfoDTO> selectAllZhrjAlarmInfos();


    /**
     * 分页查询事件信息
     * @param start 开始
     * @param end 结束
     * @return
     */
    public ArrayList<ExcelZhrjAlarmInfoDTO> selectZhrjAlarmInfosPageByType(@Param("start") int start,@Param("end") int end,@Param("type") int type);
//    public ArrayList<ExcelZhrjAlarmInfoDTO> selectZhrjAlarmInfosPageByType(@Param("start") int start,@Param("end") int end);

}
