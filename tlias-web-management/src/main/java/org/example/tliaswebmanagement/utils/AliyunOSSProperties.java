package org.example.tliaswebmanagement.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * 阿里云OSS配置类
 * @Data: 提供getter和setter方法
 * @Component: 交给IOC容器管理
 * @ConfigurationProperties: 指定配置文件中前缀为aliyun.oss的属性将绑定到本类的属性上
 */

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {

    private String endpoint;
    private String bucketName;
    private String region;

}
