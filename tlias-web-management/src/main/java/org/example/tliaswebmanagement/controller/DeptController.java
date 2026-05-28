package org.example.tliaswebmanagement.controller;

import org.example.tliaswebmanagement.pojo.Dept;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//接口暴露
//接受请求 -> 调用scrvice -> 响应结果
@RestController
public class DeptController {
    //注入service注解
    @Autowired
    private DeptService deptService;

    //接受请求 响应结果
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)   // 请求的路径
    // 查询全部部门数据
    @GetMapping("/depts")
    public Result list(){
        System.out.println("查询全部部门数据");
        //调用service,封装成List<Dept>
        List<Dept> depts = deptService.findAll();
        return Result.success(depts);
    }

    //删除部门
    @DeleteMapping("/depts")
    public Result delete(@RequestParam Integer id){ // 保证请求参数名与方法参数名一致   @RequestParam("id") Integer id
        System.out.println("根据id删除的部门是" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    //添加部门
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("添加的部门是" + dept);
        deptService.add(dept);
        return Result.success();
    }

    //查询回显
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable Integer id){ //拿到路径参数
        System.out.println("查询回显的部门是" + id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改的部门是" + dept);
        deptService.update(dept);
        return Result.success();
    }

}
