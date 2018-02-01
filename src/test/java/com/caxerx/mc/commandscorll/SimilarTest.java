package com.caxerx.mc.commandscorll;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SimilarTest {
    @Test
    public void testSimilarity() {
        System.out.println(StringUtils.getJaroWinklerDistance("a","b"));
        System.out.println(StringUtils.getJaroWinklerDistance("abc","abb"));
        System.out.println(StringUtils.getJaroWinklerDistance("abc","acc"));
        System.out.println(StringUtils.getJaroWinklerDistance("abc","acb"));
        System.out.println(StringUtils.getJaroWinklerDistance("abc","ajj"));
        System.out.println(StringUtils.getJaroWinklerDistance("abcbabc","abc"));
        System.out.println(StringUtils.getJaroWinklerDistance("abc","abcbabc"));
        System.out.println(StringUtils.getJaroWinklerDistance("aaaaaaa","aaab"));
    }
}
