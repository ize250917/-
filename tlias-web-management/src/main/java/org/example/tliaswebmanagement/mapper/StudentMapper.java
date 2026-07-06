package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.pojo.Student;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> list(String name, Integer degree, Integer clazzId);

    List<Map<String, Object>> getStudentCount();

    void insert(Student student);

    Student selectByPrimaryKey(Integer id);

    void updateByPrimaryKey(Student student);

    void deleteBatch(List<Integer> ids);

    void violation(Integer id, Integer score);

    List<Map<String, Integer>> countStudentDegreeData();
}
