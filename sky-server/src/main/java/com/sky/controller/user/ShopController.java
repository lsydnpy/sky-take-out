package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.sky.constant.ShopStatusConstant.KEY;
@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
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
