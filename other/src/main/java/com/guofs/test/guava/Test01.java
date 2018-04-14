package com.guofs.test.guava;

/**
 * @Author: GuoFangshi
 * @Date: 2018/4/14 15:19
 */
public class Test01 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.sum(1, null, 3, 4));
    }

    public Integer sum(Integer ...integers) {
        Integer result = 0;
        for (int i = 0; i < integers.length; i++) {
            result = Integer.sum(result, integers[i]);
        }
        return result;
    }
}
