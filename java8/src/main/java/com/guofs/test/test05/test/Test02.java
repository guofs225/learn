package com.guofs.test.test05.test;

import java.util.stream.IntStream;

/**
 * @Author: GuoFangshi
 * @Date: 2018/4/12 16:31
 */
public class Test02 {
    public static void main(String[] args) {
        int a = 3;
        IntStream.rangeClosed(1, 1000000)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                .forEach(b -> System.out.println(b[0] + " " + b[1] + " " + b[2]));
    }
}
