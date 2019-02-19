package com.ice.wangzherongyao.controller;

import com.ice.common.BaseResponse;
import com.ice.pingyin.PinyinHelperUtil;
import com.ice.wangzherongyao.HeroIdCache;
import com.ice.wangzherongyao.HeroManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("hero")
public class WangzherongyaoController {

  @RequestMapping(value = "/{heroId}", method = RequestMethod.GET)
  public BaseResponse getHeroDetail(@PathVariable("heroId") String heroId) {
    if (!HeroIdCache.getHeroIdCache().containsKey(heroId)) {
      return BaseResponse.builder().isSuccess(false).msg("Hero not existed.").build();
    }
    return BaseResponse.builder().isSuccess(true).data(HeroManager.getHeroDetail(heroId)).build();
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public BaseResponse getHeroList() {
    Function<Map.Entry<String, String>, Object> mapper = new Function<Map.Entry<String, String>, Object>() {
      @Override
      public Object apply(Map.Entry<String, String> entry) {
        Map<String, String> heroIdInfo = new HashMap<>();
        heroIdInfo.put("heroId", entry.getKey());
        heroIdInfo.put("heroName", entry.getValue());
        return heroIdInfo;
      }
    };
    Function<Map.Entry<String, String>, String> sorted = new Function<Map.Entry<String, String>, String>() {
      @Override
      public String apply(Map.Entry<String, String> entry) {
        return PinyinHelperUtil.convertToPinyin(entry.getValue());
      }
    };
    return BaseResponse.builder().isSuccess(true).data(HeroIdCache.getHeroIdCache().entrySet().stream().sorted(Comparator.comparing(sorted)).map(mapper
    ).collect(Collectors.toList())).build();
  }

}
