package com.zhrj.exam.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.github.pagehelper.PageHelper;
import com.zhrj.exam.entity.ZhrjAlarmInfo;
import com.zhrj.exam.listener.ZhrjAlarmInfoListener;
import com.zhrj.exam.service.impl.ZhrjAlarmInfoServiceImpl;
import com.zhrj.exam.vo.EventCountVO;
import com.zhrj.exam.vo.EventDateCountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 事件表 前端控制器
 * </p>
 *
 * @author zhrj
 * @since 2023-03-14
 */
@Slf4j
@RestController
@RequestMapping("/zhrj/events")
public class ZhrjAlarmInfoController {

    @Autowired
    private ZhrjAlarmInfoServiceImpl zhrjAlarmInfoService;


    /**
     * 解析上传的excel文件
     * @param file
     * @throws IOException
     */
    @PostMapping("/import")
    public void importFile(@RequestParam("file") MultipartFile file) {



        List<ZhrjAlarmInfo> zhrjAlarmInfos = new ArrayList<>();
        try{
            zhrjAlarmInfos = zhrjAlarmInfoService.processExcelFile(file);
            zhrjAlarmInfoService.addZhrjAlarmInfo(zhrjAlarmInfos);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }


    @ResponseBody
    @GetMapping("/statistic")
    public EventCountVO statistic(){
        return zhrjAlarmInfoService.statistic();
    }


    @ResponseBody
    @GetMapping("/month_date_count")
    public EventDateCountVO monthDateCount(String date){
        return zhrjAlarmInfoService.monthDateCount(date);
    }


    @GetMapping("download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String type = request.getParameter("type");
        zhrjAlarmInfoService.download(start,end,type,response);
    }
    @GetMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String type = request.getParameter("type");
        zhrjAlarmInfoService.test();
    }


}
