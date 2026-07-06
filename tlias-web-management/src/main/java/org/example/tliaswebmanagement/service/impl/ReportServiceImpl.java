package org.example.tliaswebmanagement.service.impl;

import org.example.tliaswebmanagement.mapper.ClazzMapper;
import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.ClazzCountOption;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

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

    //统计每个班级的学生人数
    @Override
    public ClazzCountOption getStudentCountData() {
        List<Map<String, Object>> countList = studentMapper.getStudentCount();
        if (!CollectionUtils.isEmpty(countList)) {
            List<Object> clazzList = countList.stream()
                    .map(map -> map.get("cname"))
                    .toList();

            List<Object> dataList = countList.stream()
                    .map(map -> map.get("scount"))
                    .toList();

            return new ClazzCountOption(clazzList, dataList);
        }
        return null;
    }

    @Override
    public List<Map<String, Integer>> getStudentDegreeData() {
        //调用Mapper接口,查询学员学历分布数据
        return studentMapper.countStudentDegreeData();
    }
}