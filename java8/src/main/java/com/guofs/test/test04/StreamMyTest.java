package com.guofs.test.test04;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/27 16:28
 */
public class StreamMyTest {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(54, 1, 63, 2, 55, 2, 76, 44, 12, 4123, 31, 42, 334, 4123, 334, 21, 53,324, 564, 23, 64, 734, 42, 53, 72);
        Optional<Integer> maxi = integers.stream().min(Integer::compareTo);
        System.out.println(maxi.orElse(-1));
    }
}
