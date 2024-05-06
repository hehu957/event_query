package com.zhrj.exam.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhrj.exam.common.ZhrjCommon;
import com.zhrj.exam.dto.DateEvent;
import com.zhrj.exam.dto.DeptEvent;
import com.zhrj.exam.dto.ExcelZhrjAlarmInfoDTO;
import com.zhrj.exam.dto.TypeEvent;
import com.zhrj.exam.entity.ZhrjAlarmInfo;
import com.zhrj.exam.listener.ZhrjAlarmInfoListener;
import com.zhrj.exam.mapper.ZhrjAlarmInfoMapper;
import com.zhrj.exam.service.IZhrjAlarmInfoService;
import com.zhrj.exam.vo.EventCountVO;
import com.zhrj.exam.vo.EventDateCountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 事件表 服务实现类
 * </p>
 *
 * @author zhrj
 * @since 2023-03-14
 */
@Slf4j
@Service
public class ZhrjAlarmInfoServiceImpl extends ServiceImpl<ZhrjAlarmInfoMapper, ZhrjAlarmInfo> implements IZhrjAlarmInfoService {


    @Resource
    private ZhrjAlarmInfoMapper zhrjAlarmInfoMapper;


    /**
     * 解析文件
     *
     * @param file
     * @throws IOException
     */

    @Override
    public List<ZhrjAlarmInfo> processExcelFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            log.error("上传的文件异常，请检查上传的文件");
            throw new RuntimeException();
        }
        // 判断文件名称
        String name = file.getOriginalFilename();
        if (!ZhrjCommon.FINE_NAME.equals(name)) {
            log.error("未按约定上传文件,上传的文件名为：{}",name);
            throw new RuntimeException();
        }
        List<ZhrjAlarmInfo> dataList = new ArrayList<>();
        EasyExcel.read(file.getInputStream(), ZhrjAlarmInfo.class, new ZhrjAlarmInfoListener(dataList)).sheet().doRead();
        log.info("上传文件信息：{}",dataList);
        return dataList;
    }


    /**
     * 数据入库
     * @param dataList excel信息
     */
//    @Transactional(rollbackFor = Exception.class)
    public void addZhrjAlarmInfo(List<ZhrjAlarmInfo> dataList){
       zhrjAlarmInfoMapper.saveBatch(dataList);
    }


    /**
     * 统计查询部门和事件类型对应的事件数量
     * @return
     */
    public EventCountVO statistic() {
        ArrayList<DeptEvent> deptEvents = zhrjAlarmInfoMapper.selectAllDeptEvents();
        ArrayList<TypeEvent> typeEvents = zhrjAlarmInfoMapper.selectAllTypeEvents();
        EventCountVO eventCountVO = new EventCountVO(deptEvents,typeEvents);
        log.info("statistic统计结果为：{}",eventCountVO);
        return eventCountVO;
    }


    /**
     * 按日期查询事件
     * @param date 日期
     * @return
     */
    public EventDateCountVO monthDateCount(String date) {
        log.info("接收到的日期：{}",date);
        ArrayList<DateEvent> dateEventArrayList = new ArrayList<>();
        ArrayList<DateEvent> dateEvents = zhrjAlarmInfoMapper.selectAllEventsByDate(date);
        dateEvents.forEach((dateEvent)->{
            dateEventArrayList.add(dateEvent);
        });
        return new EventDateCountVO(dateEventArrayList);
    }



    /**
     * 文件下载
     * @param start 分页坐标
     * @param end 一页中数量
     * @param type 事件类型
     * @param response
     * @throws IOException
     */
    public void download(String start,String end,String type,HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(ZhrjCommon.DOWNLOAD_FINE_NAME, "UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fileName);
        ExcelWriterBuilder workBook = EasyExcel.write(response.getOutputStream(), ExcelZhrjAlarmInfoDTO.class);
        ExcelWriterSheetBuilder sheet = workBook.sheet("模板");
        sheet.doWrite(createData(start,end,type));
    }

    public void test(){
        String start = "";
        String end = "";
        String type = "" ;
        createData(start,end,type);
    }


    /**
     * 组装数据
     * @param start  开始
     * @param end    页数量
     * @param type   事件类型
     * @return
     */
    private List<ExcelZhrjAlarmInfoDTO> createData(String start,String end,String type) {
        if("".equals(start)){
            Page<DateEvent> page = PageHelper.startPage(1,10);
            zhrjAlarmInfoMapper.selectAllZhrjAlarmInfos();
            System.out.println("total:"+page.getTotal());
            return null;
        }else {
            return zhrjAlarmInfoMapper.selectZhrjAlarmInfosPageByType(Integer.valueOf(start),Integer.valueOf(end),Integer.valueOf(type));
        }
    }




}
