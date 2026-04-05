package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.sky.constant.ShopStatusConstant.KEY;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j

public class ShopController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置店铺的营业状态
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result setStatus(@PathVariable Integer status) {

        log.info("设置店铺的营业状态，状态：{}", status == 1 ? "营业" : "打烊");
        stringRedisTemplate.opsForValue().set(KEY, status.toString());
        return Result.success();
    }
    /**
     * 获取店铺的营业状态
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result getStatus() {
        String status = stringRedisTemplate.opsForValue().get(KEY);
        log.info("获取店铺的营业状态，状态：{}", status == "1" ? "营业" : "打烊");
        return Result.success(Integer.parseInt(status));
    }

}
