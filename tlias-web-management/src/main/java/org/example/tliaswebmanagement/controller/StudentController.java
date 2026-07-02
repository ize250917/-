package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.ClazzService;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClazzService clazzService;

    //查询所有班级信息
    @GetMapping("/clazz")
    public Result listAll() {
        log.info("查询所有班级信息");
        return Result.success(clazzService.getAll());
    }

    //查询学生列表（分页）
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer degree,
                       Integer clazzId) {
        log.info("查询学生信息, page={}, pageSize={},name={},degree={},clazzId={}", page, pageSize, name, degree, clazzId);
        PageResult pageResult = studentService.page(page, pageSize, name, degree, clazzId);
        return Result.success(pageResult);
    }

}
