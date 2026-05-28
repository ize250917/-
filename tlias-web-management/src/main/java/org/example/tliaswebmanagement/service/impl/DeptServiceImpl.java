package org.example.tliaswebmanagement.service.impl;

import org.example.tliaswebmanagement.mapper.DeptMapper;
import org.example.tliaswebmanagement.pojo.Dept;
import org.example.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//业务处理层（逻辑）
@Service
public class DeptServiceImpl implements DeptService {

    //调用Mapper接口
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //补全基础属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用mapper
        deptMapper.insert(dept);

    }

    @Override
    public Dept getInfo(Integer id) {
        return deptMapper.getInfo(id);
    }

    @Override
    public void update(Dept dept) {
        //补全基础属性
        dept.setUpdateTime(LocalDateTime.now());
        //调用mapper
        deptMapper.update(dept);
    }


}
