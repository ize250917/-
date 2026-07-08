package org.example.tliaswebmanagement.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.LoginInfo;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /*
    * 登录操作
    */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录操作，emp={}", emp);
        LoginInfo info = empService.login(emp);
        if(info != null){
            return Result.success(info);
        }
        return Result.error("账号或密码错误");
    }

}
