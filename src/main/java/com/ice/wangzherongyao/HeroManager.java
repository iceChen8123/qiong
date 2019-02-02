package com.ice.wangzherongyao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ice.wangzherongyao.relationhero.InhibitHero;
import com.ice.wangzherongyao.relationhero.ParternerHero;
import com.ice.wangzherongyao.relationhero.ResistHero;
import com.ice.wangzherongyao.util.SimpleHeroInfoFormat;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroManager {

  private static final Map<String, Hero> heroInfoCache = new HashMap<>();

  private static final String preUrl = "https://pvp.qq.com/zlkdatasys/zsbd_herolist/";
  private static final String suffUrl = ".json";

  private static boolean alreadyFetch = false;

  public static List<Hero> getHeroList() {
    if (!alreadyFetch) {
      alreadyFetch = true;
      getHeroDetail();
    }
    return new ArrayList<>(heroInfoCache.values());
  }

  private static void getHeroDetail() {
    HeroIdCache.getHeroIdCache().entrySet().forEach(heroEntry -> {
      String heroId = heroEntry.getKey();
      heroInfoCache.put(heroId, getHeroDetail(heroId));
    });
  }

  public static Hero getHeroDetail(String heroId) {
    Hero hero = new Hero();
    try {

      InputStream content = HttpClientBuilder.create().build().execute(new HttpGet(preUrl + heroId + suffUrl)).getEntity().getContent();
      String str = IOUtils.toString(content, "utf-8");
      ObjectMapper mapper = new ObjectMapper();
      Map<String, String> heroDetail = mapper.readValue(str, Map.class);

      hero.setId(heroId);
      hero.setName(heroDetail.get("cname"));
      hero.setTitle(heroDetail.get("title"));
      hero.setSkin(heroDetail.get("skin_name"));
      hero.setSkillPoint(heroDetail.get("add_skill1"));
      hero.setSkillPointExp(heroDetail.get("add_skill_exp1"));
      hero.setBetterCombat(heroDetail.get("resisttips"));
      hero.setChangetime(heroDetail.get("changetime"));
      hero.setSurviveTag(heroDetail.get("survive_tag"));
      hero.setAttackTag(heroDetail.get("attack_tag"));
      hero.setSkillTag(heroDetail.get("skill_tag"));
      hero.setDifficultyTag(heroDetail.get("difficulty_tag"));
      hero.setRoad(heroDetail.get("road"));

      hero.setSkills(fetchSkills(heroDetail));
      hero.setParternerList(fetchPartner(heroDetail));
      hero.setInhibitHeroList(fetchInhibitHero(heroDetail));
      hero.setResistHeroList(fetchResistHero(heroDetail));

//        hero.setStory(heroDetail.get("story"));
//        hero.setHistory(heroDetail.get("history"));
//        hero.setMingWenExp(heroDetail.get("fuwenid_exp"));
      hero.setUsetips(new StringBuilder(heroDetail.get("usetips")).append("---").append(heroDetail.get("use_tips")).toString());
      hero.setWartips(heroDetail.get("wartips"));
      hero.setChangetip(heroDetail.get("changetip"));

    } catch (IOException e) {
      e.printStackTrace();
    }
    return hero;
  }

  private static List<ResistHero> fetchResistHero(Map<String, String> heroDetail) {
    List<ResistHero> rtnList = new ArrayList<>();
    String idNameTemp = "resist@";
    String tipTemp = "re_tip@";
    for (int i = 0; i < 5; i++) {
      String heroId = heroDetail.get(idNameTemp.replace("@", i + ""));
      if (StringUtils.isNotBlank(heroId)) {
        ResistHero parterner = new ResistHero();
        parterner.setHero(heroInfoCache.get(heroId));
        parterner.setInfo(heroDetail.get(tipTemp.replace("@", i + "")));
        rtnList.add(parterner);
      }
    }
    return rtnList;
  }

  private static List<InhibitHero> fetchInhibitHero(Map<String, String> heroDetail) {
    List<InhibitHero> rtnList = new ArrayList<>();
    String idNameTemp = "inhibit@";
    String tipTemp = "in_tip@";
    for (int i = 0; i < 5; i++) {
      String heroId = heroDetail.get(idNameTemp.replace("@", i + ""));
      if (StringUtils.isNotBlank(heroId)) {
        InhibitHero parterner = new InhibitHero();
        parterner.setHero(heroInfoCache.get(heroId));
        parterner.setInfo(heroDetail.get(tipTemp.replace("@", i + "")));
        rtnList.add(parterner);
      }
    }
    return rtnList;
  }

  private static List<ParternerHero> fetchPartner(Map<String, String> heroDetail) {
    List<ParternerHero> rtnList = new ArrayList<>();
    String idNameTemp = "partner@";
    String tipTemp = "part_tip@";
    String yipTemp = "part_yip@";
    for (int i = 0; i < 5; i++) {
      String heroId = heroDetail.get(idNameTemp.replace("@", i + ""));
      if (StringUtils.isNotBlank(heroId)) {
        ParternerHero parterner = new ParternerHero();
        parterner.setHero(heroInfoCache.get(heroId));
        String info = heroDetail.get(tipTemp.replace("@", i + ""));
        if (StringUtils.isBlank(info)) {
          info = heroDetail.get(yipTemp.replace("@", i + ""));
        }
        parterner.setInfo(info);
        rtnList.add(parterner);
      }
    }
    return rtnList;
  }

  private static List<Skill> fetchSkills(Map<String, String> heroDetail) {
    List<Skill> skills = new ArrayList<>(10);
    String nameTemp = "skill@_name";
    String descTemp = "skill@_des";
    String tipTemp = "skill@_tips";
    for (int i = 0; i < 10; i++) {
      String skillName = heroDetail.get(nameTemp.replace("@", i + ""));
      if (StringUtils.isNotBlank(skillName)) {
        Skill skill = new Skill();
        skill.setName(skillName);
//        skill.setDesc(heroDetail.get(descTemp.replace("@", i + "")));
//        skill.setTip(heroDetail.get(tipTemp.replace("@", i + "")));
        skills.add(skill);
      } else {
        return skills;
      }
    }
    return skills;
  }

  public static void main(String[] args) {
    System.out.println(new SimpleHeroInfoFormat().fromHero(getHeroDetail("190")));
  }

}
