package org.example.tliaswebmanagement.service;


import org.example.tliaswebmanagement.pojo.ClazzCountOption;
import org.example.tliaswebmanagement.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    /**
     * 统计各个性别员工人数
     * @return
     */
    List<Map<String, Integer>> getEmpGenderData();

    /**
     * 统计每个班级的学生人数
     * @return
     */
    ClazzCountOption getStudentCountData();

    List<Map<String, Integer>> getStudentDegreeData();
}