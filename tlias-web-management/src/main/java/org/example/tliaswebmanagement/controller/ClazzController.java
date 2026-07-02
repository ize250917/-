package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.ClazzService;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private EmpService empService;

    //班级列表查询(分页)
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page ,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("查询员工信息, page={}, pageSize={},name={},begin={},end={}", page, pageSize, name, begin,end);
        PageResult pageResult = clazzService.page(page, pageSize, name, begin,end);
        return Result.success(pageResult);
    }

    /*删除班级
    * @param id 班级id
    * @PathVariable 从路径中获取参数, 并将其绑定到方法参数上
    */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除班级, id={}", id);
        clazzService.delete(id);
        return Result.success();
    }

    //查询所有班主任信息
    // 查询所有班主任（job = 1）
    @GetMapping("/teachers")
    public Result listTeachers() {
        return Result.success(empService.getAllTeacher(1));
    }


    /*添加班级
    *@RequestBody 从请求体中获取参数, 并将其绑定到方法参数上
    */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级, clazz={}", clazz);
        clazzService.add(clazz);
        return Result.success();
    }


    /*
     * 查询回显班级信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据班级id查询班级信息, id={}", id);
        return Result.success(clazzService.get(id));
    }


    /*
    * 修改班级信息
    */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息, clazz={}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

}
