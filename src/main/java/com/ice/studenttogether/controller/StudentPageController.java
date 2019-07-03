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
    nameCache.put("chengzixuan-050970701", "程子轩");
    nameCache.put("guojia-050970702", "郭嘉");
    nameCache.put("lijing-050970703", "李婧");
    nameCache.put("maxuejie-050970704", "马雪洁");
    nameCache.put("shifangjun-050970705", "施方珺");
    nameCache.put("wanglai-050970706", "王莱");
    nameCache.put("yejiahui-050970707", "叶佳晖");
    nameCache.put("zhuwenxin-050970708", "诸雯欣");
    nameCache.put("caihaijia-050970709", "蔡海嘉");
    nameCache.put("chenxin-050970710", "陈鑫");
    nameCache.put("fengyan-050970711", "冯岩");
    nameCache.put("hefei-050970712", "何菲");
    nameCache.put("huanglei-050970713", "黄雷");
    nameCache.put("kongdelong-050970714", "孔德龙");
    nameCache.put("liyuhang-050970715", "李宇航");
    nameCache.put("liushixia-050970716", "刘士夏");
    nameCache.put("luohao-050970717", "罗浩");
    nameCache.put("pengkecheng-050970718", "彭科铖");
    nameCache.put("shihongyuan-050970719", "施鸿远");
    nameCache.put("sunyin-050970720", "孙寅");
    nameCache.put("wangkun-050970721", "王昆");
    nameCache.put("wuleyu-050970722", "吴乐愚");
    nameCache.put("xuwei-050970723", "徐伟");
    nameCache.put("yangzhiyong-050970724", "杨智勇");
    nameCache.put("zhaiyinfei-050970721", "翟寅飞");
    nameCache.put("zhaopeng-050970722", "赵鹏");
    nameCache.put("zhangliwen-050970723", "张力文");
    nameCache.put("zhujie-050970724", "朱杰");

  }

  @RequestMapping("/{school}/{detail}")
  public ModelAndView toIndexPage(@PathVariable("school") String school, @PathVariable("detail") String detail) {
    Map<String, Object> model = new HashMap<>();
    String[] detailInfo = detail.split("-");
    model.put("school", school);
    String key = detailInfo[0] + "-" + detailInfo[1];
    model.put("name", nameCache.containsKey(key) ? nameCache.get(key) : detailInfo[0]);
    model.put("studentId", detailInfo[1]);
    model.put("photoPath", PhotoPathUtil.getPhotoPath(key));
    model.put("enrollmentYear", detailInfo[2]);
    return new ModelAndView("student-together/tongxuehui", model);
  }

}
