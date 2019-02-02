package com.ice.pingyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinHelperUtil {

  private static final HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();

  static {
    hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
  }

  public static String convertToPinyin(String string) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : string.toCharArray()) {
      try {
        stringBuilder.append(PinyinHelper.toHanyuPinyinStringArray(c, hanyuPinyinOutputFormat)[0]);
      } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
        badHanyuPinyinOutputFormatCombination.printStackTrace();
      }
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {

    String string = "бли╚";
    System.out.println(convertToPinyin(string));
//    System.out.println(PinyinHelper.toGwoyeuRomatzyhStringArray(string.charAt(0))[0] + ":::");
//    System.out.println(PinyinHelper.toMPS2PinyinStringArray(string.charAt(0))[0] + ":::");
//    System.out.println(PinyinHelper.toTongyongPinyinStringArray(string.charAt(0))[0] + ":::");
//    System.out.println(PinyinHelper.toWadeGilesPinyinStringArray(string.charAt(0))[0] + ":::");
//    System.out.println(PinyinHelper.toYalePinyinStringArray(string.charAt(0))[0] + ":::");
  }

}
