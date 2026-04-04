package com.sky.controller.admin;


import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sky.result.Result;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

import static com.sky.constant.MessageConstant.UPLOAD_FAILED;

/**
 * 通用controller
 */
@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {
    @Resource
    private AliOssUtil aliOssUtil;

    /**
     * 上传文件
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file.getOriginalFilename());

        try {
            String filename = file.getOriginalFilename();//原始文件名
            //获取原始文件名后缀
            String suffix = filename.substring(filename.lastIndexOf("."));
            //添加UUID防止文件名重复
            String objectName = UUID.randomUUID().toString() + suffix;
            String url = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(url);
        } catch (Exception e) {
            log.error(UPLOAD_FAILED, e);
        }
        return Result.error(UPLOAD_FAILED);
    }



}
