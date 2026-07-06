package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.service.ClazzService;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //新增学生
    @PostMapping
    public Result add(@RequestBody Student student) {
        log.info("新增学生信息, student={}", student);
        studentService.add(student);
        return Result.success();
    }

    //根据id查询学生信息
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询学生信息, id={}", id);
        Student student = studentService.get(id);
        return Result.success(student);
    }

    //修改学生信息
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生信息, student={}", student);
        studentService.update(student);
        return Result.success();
    }

    //删除学生信息
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除学生信息, ids={}", ids);
        studentService.delete(ids);
        return Result.success();
    }

    //违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("违纪处理, id={}, score={}", id, score);
        studentService.violation(id, score);
        return Result.success();
    }

}
