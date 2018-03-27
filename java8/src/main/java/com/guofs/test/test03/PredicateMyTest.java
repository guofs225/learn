package com.guofs.test.test03;

import java.util.function.IntPredicate;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/27 9:15
 */
public class PredicateMyTest {
    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println(evenNumbers.test(1001));
    }
}
