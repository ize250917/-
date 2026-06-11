package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /*
    * 分页查询（原始）
    * @RequestParam 默认值
    * log 日志
    * return 分页数据
    */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page ,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("查询员工信息, page={}, pageSize={},name={},gender={},begin={},end={}", page, pageSize, name, gender, begin,end);
        PageResult pageResult = empService.page(page, pageSize, name, gender, begin,end);
        return Result.success(pageResult);
    }

    //新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工, {}", emp);
        empService.save(emp);
        return Result.success();
    }


    /**
     * 批量删除员工
     * RequestParam 查询参数
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除员工: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    //查询回显
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /*
     * 修改员工信息
     * RequestBody 请求体参数
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }
}