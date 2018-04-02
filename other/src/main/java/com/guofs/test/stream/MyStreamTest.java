package com.guofs.test.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/28 10:57
 */
public class MyStreamTest {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 2, 55, 21);
        List<Integer> finallyInts = integers.stream().filter(i -> i > 100).map(i -> i * 100).collect(toList());
        System.out.println(finallyInts);
    }
}
