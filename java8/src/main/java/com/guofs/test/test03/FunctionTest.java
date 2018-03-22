package com.guofs.test.test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/22 15:46
 *
 * Function初学习尝试
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> f = String::length;
        List<Integer> integers = map(
                Arrays.asList("asda", "a11111", "safff", "ad", "asdasdasdasd"),
                f.andThen(i -> i * 10).compose(s -> s + "a"));
        System.out.println(integers);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
