package com.ice.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*", filterName = "IpFilter")
@Slf4j
public class IpFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest requestTmp = (HttpServletRequest) request;
    if (requestTmp.getRequestURI().contains("static") || requestTmp.getMethod().equalsIgnoreCase("get")) {
      chain.doFilter(request, response);
      return;
    }

    String ipAddress = requestTmp.getHeader("x-forwarded-for");
    if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = requestTmp.getHeader("Proxy-Client-IP");
    }
    if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = requestTmp.getHeader("WL-Proxy-Client-IP");
    }
    if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
      ipAddress = request.getRemoteAddr();
      if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
        //根据网卡取本机配置的IP  
        InetAddress inet = null;
        try {
          inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
          e.printStackTrace();
        }
        ipAddress = inet.getHostAddress();
      }
    }
    //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
    if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
      if (ipAddress.indexOf(",") > 0) {
        ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
      }
    }
    log.info("incoming ip : " + ipAddress + "; uri : " + requestTmp.getRequestURI());
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}
