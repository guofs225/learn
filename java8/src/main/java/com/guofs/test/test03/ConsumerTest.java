package com.guofs.test.test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/22 15:16
 *
 * Consumer初步学习实践
 */
public class ConsumerTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Consumer<Integer> c = i -> System.out.print(" *first: " + i);
        System.out.println();
        forEach(integers, c.andThen(i -> System.out.print(" second: " + i)).andThen((t) -> {}));
        System.out.println();
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for(T t: list) {
            c.accept(t);
        }
    }
}
