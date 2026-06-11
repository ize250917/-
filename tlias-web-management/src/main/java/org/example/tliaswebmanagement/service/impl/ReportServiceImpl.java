package org.example.tliaswebmanagement.service.impl;

import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        //调用Mapper接口,查询各个职位的员工人数
        List<Map<String, Object>> maps = empMapper.countEmpJobData();
        //创建两个集合，分别存储职位名称和职位员工人数
        List<Object> jobList = maps.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = maps.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Integer>> getEmpGenderData() {
        //调用Mapper接口,查询各个性别员工人数
        return empMapper.countEmpGenderData();
    }
}