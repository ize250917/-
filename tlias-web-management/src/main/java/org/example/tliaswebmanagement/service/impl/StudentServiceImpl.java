package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public void add(Student student) {
        //补全基础属性
        student.setCreateTime(LocalDateTime.now()); //创建时间
        student.setUpdateTime(LocalDateTime.now()); //修改时间
        //调用Mapper接口,新增学生
        studentMapper.insert(student);
    }

    //根据id查询学生信息(查询回显)
    @Override
    public Student get(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    //修改学生信息
    @Override
    public void update(Student student) {
        //补全基础属性
        student.setUpdateTime(LocalDateTime.now()); //修改时间
        //调用Mapper接口,修改学生
        studentMapper.updateByPrimaryKey(student);
    }

    //删除学生信息（批量删除学生）
    @Override
    public void delete(List<Integer> ids) {
        //调用Mapper接口,删除学生
        studentMapper.deleteBatch(ids);
    }

    @Override
    public void violation(Integer id, Integer score) {
        //调用Mapper接口,违纪处理
        studentMapper.violation(id, score);
    }
}
