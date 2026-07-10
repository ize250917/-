package org.example.tliaswebmanagement.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    //登录信息类
    private Integer id;
    private String username;
    private String password;
    private String token;
}
