package com.ice.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = ControllerExceptionAdvicer.class)
@Slf4j
public class ControllerExceptionAdvicer extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  @ResponseBody
  protected ResponseEntity<Object> handleControllerException(HttpServletRequest request, Throwable ex) {
    log.warn("something wrong.....", ex);
    return new ResponseEntity<>(BaseResponse.builder().isSuccess(false).msg(ex.getMessage()).build(), HttpStatus.OK);
  }

}
