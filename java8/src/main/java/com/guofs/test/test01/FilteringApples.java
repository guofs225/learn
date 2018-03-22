package com.guofs.test.test01;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/22 10:56
 */
public class FilteringApples {
    public static void main(String[] args) {
        filterApples(() -> System.out.println("123"));
    }

    public static void filterApples(ApplePredicate predicate){
        predicate.filter();
    }
}
