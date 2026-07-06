package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Student;

import java.util.List;

public interface StudentService {
    PageResult page(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId);

    void add(Student student);

    Student get(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void violation(Integer id, Integer score);
}
