package cn.zm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class LeftMoveRightMove {

  public String formatIntToBinary(Integer val) {
    Assert.assertNotNull("invalid parameter", val);
    String binaryString = Integer.toBinaryString(val);
    StringBuilder sb = new StringBuilder(binaryString);
    StringBuilder reverse = sb.reverse();
    int length = binaryString.length();
    for (int i = 0; i <= length; i++) {
      if ((i+1) % 5 == 0 && i != reverse.length()) {
        reverse.insert(i, "_");
        length++;
      }
    }
    return reverse.reverse().toString();
  }

  @Test
  public void leftMove() {
    log.info("-10[{}]",formatIntToBinary(-10));
    log.info(" 10[{}]",formatIntToBinary(10));

    log.info("------------");
    log.info("-10 >> 1[{}]", formatIntToBinary(-10 >> 1));
    log.info(" 10 >> 1[{}]", formatIntToBinary(10 >> 1));
    log.info("-10 >> 1[{}]", -10 >> 1);
    log.info(" 10 >> 1[{}]", 10 >> 1);

    log.info("------------");
    log.info("-10 >>> 1[{}]", formatIntToBinary(-10 >>> 1));
    log.info(" 10 >>> 1[{}]", formatIntToBinary(10 >>> 1));
    log.info("-10 >>> 1[{}]", -10 >>> 1);
    log.info(" 10 >>> 1[{}]", 10 >>> 1);


  }

}
