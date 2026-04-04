package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 阿里云OSS配置类，用于配置OSS的端点、访问密钥ID、访问密钥密钥和默认存储空间
 */
@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean// 如果容器中没有AliOssUtil的实例，则创建一个AliOssUtil实例，否则使用容器中的实例
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties) {
        log.info("创建AliOssUtil实例");
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),
                aliOssProperties.getBucketName());
    }

}
