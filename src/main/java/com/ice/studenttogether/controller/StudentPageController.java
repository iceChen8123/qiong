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
    nameCache.put("chengzixuan-050970701", "³Ì×ÓĞù");
    nameCache.put("guojia-050970702", "¹ù¼Î");
    nameCache.put("lijing-050970703", "Àîæº");
    nameCache.put("maxuejie-050970704", "ÂíÑ©½à");
    nameCache.put("shifangjun-050970705", "Ê©·½¬B");
    nameCache.put("wanglai-050970706", "ÍõÀ³");
    nameCache.put("yejiahui-050970707", "Ò¶¼ÑêÍ");
    nameCache.put("zhuwenxin-050970708", "Öîö©ĞÀ");
    nameCache.put("caihaijia-050970709", "²Ìº£¼Î");
    nameCache.put("chenxin-050970710", "³ÂöÎ");
    nameCache.put("fengyan-050970711", "·ëÑÒ");
    nameCache.put("hefei-050970712", "ºÎ·Æ");
    nameCache.put("huanglei-050970713", "»ÆÀ×");
    nameCache.put("kongdelong-050970714", "¿×µÂÁú");
    nameCache.put("liyuhang-050970715", "ÀîÓîº½");
    nameCache.put("liushixia-050970716", "ÁõÊ¿ÏÄ");
    nameCache.put("luohao-050970717", "ÂŞºÆ");
    nameCache.put("pengkecheng-050970718", "Åí¿Æîñ");
    nameCache.put("shihongyuan-050970719", "Ê©ºèÔ¶");
    nameCache.put("sunyin-050970720", "ËïÒú");
    nameCache.put("wangkun-050970721", "ÍõÀ¥");
    nameCache.put("wuleyu-050970722", "ÎâÀÖÓŞ");
    nameCache.put("xuwei-050970723", "ĞìÎ°");
    nameCache.put("yangzhiyong-050970724", "ÑîÖÇÓÂ");
    nameCache.put("zhaiyinfei-050970721", "µÔÒú·É");
    nameCache.put("zhaopeng-050970722", "ÕÔÅô");
    nameCache.put("zhangliwen-050970723", "ÕÅÁ¦ÎÄ");
    nameCache.put("zhujie-050970724", "Öì½Ü");

  }

  @RequestMapping("/{school}/{detail}")
  public ModelAndView toIndexPage(@PathVariable("school") String school, @PathVariable("detail") String detail) {
    Map<String, Object> model = new HashMap<>();
    String[] detailInfo = detail.split("-");
    model.put("school", school);
    model.put("name", nameCache.containsKey(detailInfo[0] + "-" + detailInfo[1]) ? nameCache.get(detailInfo[0] + "-" + detailInfo[1]) : detailInfo[0]);
    model.put("studentId", detailInfo[1]);
    String photoPath = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562074361119&di=60cf35fdc59ab15f3329d625d70e1791&imgtype=0&src=http%3A%2F%2Fimg1.touxiang.cn%2Fuploads%2F20131107%2F07-062241_330.jpg";
    model.put("photoPath", photoPath);
    model.put("enrollmentYear", detailInfo[2]);
    return new ModelAndView("student-together/tongxuehui", model);
  }

}
