package algorithm;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 常见的字符串算法
 * @author 十渊
 */
@Slf4j
public class StringAlgorithm {
/**
 * 1. KMP 算法
 * 谈到字符串问题，不得不提的就是 KMP 算法，它是用来解决字符串查找的问题，
 * 可以在一个字符串（S）中查找一个子串（W）出现的位置。
 * KMP 算法把字符匹配的时间复杂度缩小到 O(m+n) ,
 * 而空间复杂度也只有O(m)。因为“暴力搜索”的方法会反复回溯主串，
 * 导致效率低下，而KMP算法可以利用已经部分匹配这个有效信息，
 * 保持主串上的指针不回溯，通过修改子串的指针，让模式串尽量地移动到有效的位置。
 */
  public void KMP () {

  }

  /**
   * 替换红字符串
   */
  public String replaceSpace(String s) {
    return s.replaceAll(" ", "%20");
  }

  /**
   * 替换红字符串
   */
  public String replaceSpace1(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(1);
    String[] chars = s.split("");
    for (int i = 0; i < chars.length; i++) {
      if (chars[i].equals(" ")) chars[i] = "%20";
      stringBuilder.append(chars[i].equals(" ") ? "%20" : chars[i]);
    }
    return stringBuilder.toString();
  }

  /**
   *   最长公共前缀
   */
  public String getCommonPrefix(String[] strings) {
    Assert.notEmpty(strings, "有空元素");

    StringBuilder commonPrefix = new StringBuilder();

    int length = strings.length;
    int m = strings[0].length();
    int n = strings[length - 1].length();
    int num = Math.min(m, n);

    Arrays.sort(strings);
    for (int i = 0; i < num; i++) {
      if (strings[0].charAt(i) == strings[length - 1].charAt(i))
        commonPrefix.append(strings[0].charAt(i));
      else break;
    }
    return commonPrefix.toString();
  }

  /**
   * 可以构成的最长回文串
   *
   * in: abccccdd
   *
   * out: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
   */
  public int longestPalindrome(String s) {
    Assert.notBlank(s, "invalid parameter");
    // 用于存放字符
    HashSet<Character> set = new HashSet<>();
    char[] chars = s.toCharArray();
    int count = 0;
    for (int i = 0; i < chars.length; i++) {
      // 如果set中没有则保存进去
      if (!set.contains(chars[i]))
        set.add(chars[i]);
      // 如果有, 则让count++（说明找到了一个成对的字符），然后把该字符移除
      else {
        set.remove(chars[i]);
        count++;
      }
    }
    return set.isEmpty() ? count*2 : count*2+1;
  }

  /**
   * 验证回文串
   *
   * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，
   * 可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
   *
   */
  public boolean isPalindrome(String s) {
    Assert.notBlank(s, "invalid parameter");
    int l = 0, r = s.length() - 1;
    // 从头到尾遍历
    while (l < r) {
      if (!Character.isLetterOrDigit(s.charAt(l))) l++;
      else if (!Character.isLetterOrDigit(s.charAt(r))) r--;
      else {
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
          return false;
        }
        l++;r--;
      }
    }
    return true;
  }

  //region 最长回文子串
  /**
   * 最长回文子串
   *
   * 最长回文子串 给定一个字符串 s，找到 s
   * 最长的回文子串。你可以假设 s 的最大长度为1000。
   *
   */
  private int index, len;
  public String childLongestPalindrome(String s) {
    Assert.isFalse(s == null || s.length() < 2, "invalid parameter");
    for (int i = 0; i < s.length() - 1; i++) {
      palindromeHelper(s, i, i);
      palindromeHelper(s, i, i + 1);
    }
    return s.substring(index, index+len);
  }
  public void palindromeHelper (String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    if (len < r - l - 1) {
      index = l + 1;
      len = r - l - 1;
    }
  }
  //endregion



  @Test
  public void test () {

    System.out.println(childLongestPalindrome("adsasadgdfsgdfsds"));
    // System.out.println(isPalindrome("fsavsaas"));
    // System.out.println(longestPalindrome("abccccdd"));

    // System.out.println(replaceSpace("aasd  asdas  ads sda dsa "));
    // System.out.println(replaceSpace1("aasd  asdas  ads sda dsa "));
    // System.out.println(getCommonPrefix(new String[]{"customer", "car", "cat"}));
  }

}
