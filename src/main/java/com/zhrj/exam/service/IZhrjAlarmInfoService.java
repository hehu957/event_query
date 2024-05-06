package com.zhrj.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhrj.exam.entity.ZhrjAlarmInfo;
import com.zhrj.exam.vo.EventCountVO;
import com.zhrj.exam.vo.EventDateCountVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 事件表 服务类
 * </p>
 *
 * @author zhrj
 * @since 2023-03-14
 */
public interface IZhrjAlarmInfoService extends IService<ZhrjAlarmInfo> {

    /**
     * 解析Excel文件
     * @param file
     */
    List<ZhrjAlarmInfo> processExcelFile(MultipartFile file) throws IOException;

    /**
     * 数据入库
     * @param dataList excel信息
     */
    public void addZhrjAlarmInfo(List<ZhrjAlarmInfo> dataList);


    /**
     * 统计查询部门和事件类型对应的事件数量
     * @return
     */
    public EventCountVO statistic();

    /**
     * 按日期查询事件
     * @param date 日期
     * @return
     */
    public EventDateCountVO monthDateCount(String date);


    /**
     * 文件下载
     * @param start 分页坐标
     * @param end 一页中数量
     * @param type 事件类型
     * @param response
     * @throws IOException
     */
    public void download(String start, String end,String type, HttpServletResponse response) throws IOException;
}
