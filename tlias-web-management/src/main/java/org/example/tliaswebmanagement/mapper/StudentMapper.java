package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.tliaswebmanagement.pojo.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> list(String name, Integer degree, Integer clazzId);
}
