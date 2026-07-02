package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.PageResult;

public interface StudentService {
    PageResult page(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId);
}
