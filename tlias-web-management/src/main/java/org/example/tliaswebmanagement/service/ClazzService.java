package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.PageResult;

import java.time.LocalDate;

public interface ClazzService {
    PageResult page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end);

    void delete(Integer id);

    void add(Clazz clazz);

    Clazz get(Integer id);

    void update(Clazz clazz);
}
