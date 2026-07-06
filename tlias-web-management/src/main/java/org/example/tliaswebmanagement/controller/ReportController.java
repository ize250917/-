package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.ClazzCountOption;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.EmpService;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别分布数据
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别分布数据");
        List<Map<String, Integer>> list = reportService.getEmpGenderData();
        return Result.success(list);
    }

    /**
     * 统计每个班级的学生人数
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("班级人数统计");
        ClazzCountOption clazzCountOption = reportService.getStudentCountData();
        return Result.success(clazzCountOption);
    }

    //学员学历统计
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历分布数据");
        List<Map<String, Integer>> list = reportService.getStudentDegreeData();
        return Result.success(list);
    }
}