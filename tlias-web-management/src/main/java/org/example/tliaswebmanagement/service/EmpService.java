package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.pojo.PageResult;

public interface EmpService {
    /**
     * 分页查询（原始）
     * @param page 页码
     * @param pageSize 每页记录数
     */
    PageResult page(Integer page, Integer pageSize);
}