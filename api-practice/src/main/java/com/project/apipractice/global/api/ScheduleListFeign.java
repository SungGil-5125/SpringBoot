package com.project.apipractice.global.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "scheduleList", url = "https://open.neis.go.kr/hub/hisTimetable")
public interface ScheduleListFeign {

    @GetMapping
    public void execute(@RequestParam("KEY") String key, @RequestParam("Type") String type, @RequestParam("pIndex") String pIndex,
                        @RequestParam("pSize") String pSize, @RequestParam("ATPT_OFCDC_SC_CODE") String cityCode, @RequestParam("SD_SCHUL_CODE") String schoolCode,
                        @RequestParam("SEM") String season, @RequestParam("grade") String grade, @RequestParam("class_nm") String className, @RequestParam("TI_FROM_YMD") String startDate, @RequestParam("TI_TO_YMD") String endDate);
}
