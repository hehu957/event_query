package com.zhrj.exam.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zhrj.exam.entity.ZhrjAlarmInfo;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Scope;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Scope("prototype")
public class ZhrjAlarmInfoListener extends AnalysisEventListener<ZhrjAlarmInfo> {

    private List<ZhrjAlarmInfo> dataList;

    public ZhrjAlarmInfoListener(List<ZhrjAlarmInfo> dataList) {
        this.dataList = dataList;
    }


    @SneakyThrows
    @Override
    public void invoke(ZhrjAlarmInfo zhrjAlarmInfo, AnalysisContext analysisContext) {
        dataList.add(zhrjAlarmInfo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
