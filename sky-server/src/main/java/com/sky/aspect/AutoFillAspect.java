package com.sky.aspect;


import com.sky.annotation.AutoFill;
import com.sky.enumeration.OperationType;
import com.sky.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import static com.sky.constant.AutoFillConstant.*;

/**
 * 自动填充切面
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut() {

    }

    /**
     * 在切入点之前执行增强方法
     * @param joinPoint
     */
    @Before("autoFillPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("自动填充切面开始执行...");
        //1、获取当前被拦截的方法上的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//获取被拦截方法的签名
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);//获取被拦截方法上的AutoFill注解对象
        OperationType operationType = autoFill.value();//获取注解对象中的数据库操作类型
        //2、获取到当前被拦截的方法参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null && args.length == 0) {
            return;
        }
        Object entity = args[0];
        //3、准备赋值数据
        LocalDateTime now = LocalDateTime.now();
        Long currentId = ThreadLocalUtil.getCurrentId(); // 获取当前登录用户ID
        //4、根据当前不同的操作类型，为对应的属性通过过反射进行赋值
        if (operationType == OperationType.INSERT) {
            //为4个字段赋值
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod(SET_CREATE_TIME, LocalDateTime.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod(SET_CREATE_USER, Long.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Long.class);
                setCreateTime.invoke(entity, now);
                setCreateUser.invoke(entity, currentId);
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentId);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(SET_UPDATE_USER, Long.class);
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentId);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
