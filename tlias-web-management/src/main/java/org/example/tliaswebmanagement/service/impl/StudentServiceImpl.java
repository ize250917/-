package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult page(Integer page, Integer pageSize, String name, Integer degree, Integer clazzId) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询（调用Mapper）
        List<Student> rows = studentMapper.list(name, degree, clazzId);
        //强转为 Page，取分页信息
        Page<Student> p = (Page<Student>) rows;
        //封装返回
        return new PageResult(p.getTotal(), p.getResult());
    }
}
