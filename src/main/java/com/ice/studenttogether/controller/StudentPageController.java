package com.ice.studenttogether.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("student-together")
public class StudentPageController {

  private static HashMap<String, String> nameCache = new HashMap<>();

  static {
    nameCache.put("caihaijia", "蔡海嘉");
    nameCache.put("chenxin", "陈鑫");
    nameCache.put("fengyan", "冯岩");
    nameCache.put("hefei", "何菲");
  }

  @RequestMapping("/{school}/{detail}")
  public ModelAndView toIndexPage(@PathVariable("school") String school, @PathVariable("detail") String detail) {
    Map<String, Object> model = new HashMap<>();
    String[] detailInfo = detail.split("-");
    model.put("school", school);
    model.put("name", nameCache.containsValue(detailInfo[0]) ? nameCache.get(detailInfo[0]) : detailInfo[0]);
    model.put("studentId", detailInfo[1]);
    String photoPath = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562074361119&di=60cf35fdc59ab15f3329d625d70e1791&imgtype=0&src=http%3A%2F%2Fimg1.touxiang.cn%2Fuploads%2F20131107%2F07-062241_330.jpg";
    model.put("photoPath", photoPath);
    model.put("enrollmentYear", detailInfo[2]);
    return new ModelAndView("student-together/tongxuehui", model);
  }

}
