package com.ice.zk.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ControllerAop {

  @Around("execution(* com.ice.*.controller.*Controller.*(..))")
  public Object performance(ProceedingJoinPoint pjp) throws Throwable {
    try {
      MDC.put("TNAME", RandomStringUtils.randomAlphabetic(20));
      if (pjp.getArgs().length > 0) {
        log.info("method : {}, args : {}", pjp.getSignature().toShortString(), Arrays.asList(pjp.getArgs()));
      }
      log.info("method 111111 bbbbbbb...................");
      Object proceed = pjp.proceed();
      log.info("method 111111 aaaaaaa...................");
      return proceed;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  @AfterThrowing(pointcut = "execution(* com.ice.*.controller.*Controller.*(..))", throwing = "e")
  public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
    log.error("method 111111 doAfterThrowing...................", e);
  }

}
