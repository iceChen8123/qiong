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
    nameCache.put("chengzixuan-050970701", "������");
    nameCache.put("guojia-050970702", "����");
    nameCache.put("lijing-050970703", "���");
    nameCache.put("maxuejie-050970704", "��ѩ��");
    nameCache.put("shifangjun-050970705", "ʩ���B");
    nameCache.put("wanglai-050970706", "����");
    nameCache.put("yejiahui-050970707", "Ҷ����");
    nameCache.put("zhuwenxin-050970708", "������");
    nameCache.put("caihaijia-050970709", "�̺���");
    nameCache.put("chenxin-050970710", "����");
    nameCache.put("fengyan-050970711", "����");
    nameCache.put("hefei-050970712", "�η�");
    nameCache.put("huanglei-050970713", "����");
    nameCache.put("kongdelong-050970714", "�׵���");
    nameCache.put("liyuhang-050970715", "���");
    nameCache.put("liushixia-050970716", "��ʿ��");
    nameCache.put("luohao-050970717", "�޺�");
    nameCache.put("pengkecheng-050970718", "�����");
    nameCache.put("shihongyuan-050970719", "ʩ��Զ");
    nameCache.put("sunyin-050970720", "����");
    nameCache.put("wangkun-050970721", "����");
    nameCache.put("wuleyu-050970722", "������");
    nameCache.put("xuwei-050970723", "��ΰ");
    nameCache.put("yangzhiyong-050970724", "������");
    nameCache.put("zhaiyinfei-050970721", "������");
    nameCache.put("zhaopeng-050970722", "����");
    nameCache.put("zhangliwen-050970723", "������");
    nameCache.put("zhujie-050970724", "���");

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
