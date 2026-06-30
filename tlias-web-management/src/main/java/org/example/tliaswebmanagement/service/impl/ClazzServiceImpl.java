package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.ClazzMapper;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {

        // 1. 设置分页参数
        PageHelper.startPage(page, pageSize);

        // 2. 执行查询（必须接收返回值）
        List<Clazz> rows = clazzMapper.list(name, begin, end);

        // 3. 强转为 Page，取分页信息
        Page<Clazz> p = (Page<Clazz>) rows;

        // 4. 封装返回
        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public void add(Clazz clazz) {
        //补全基础属性
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }
}