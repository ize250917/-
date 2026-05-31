package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.service.EmpService;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /*
     * page: 当前页码
     * start: 开始索引
     * pageSize: 每页记录数
     * return 封装结果(总记录数,结果列表)
     */

    /*
    @Override
    public PageResult page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long total = empMapper.count();

        //2. 获取结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.list(start, pageSize);

        //3. 封装结果
        return new PageResult(total, empList);
    }
    */

    //分页查询（基于pageHelper）
    @Override
    public PageResult page(Integer page, Integer pageSize) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装结果
        return new PageResult(p.getTotal(), p.getResult());
    }
}