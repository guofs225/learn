package com.guofs.test.test03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/22 14:24
 *
 * Predicate初步学习实践
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("12e3");
        listOfStrings.add("");
        listOfStrings.add("asqqd");
        listOfStrings.add("12eWa");
        listOfStrings.add("12eWasssssssssss");
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate.and((String s) -> s.length() == 5).or((String s) -> s.length() > 10).negate());
        System.out.println(nonEmpty);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s: list) {
            if (p.test(s))
                results.add(s);
        }
        return results;
    }
}
