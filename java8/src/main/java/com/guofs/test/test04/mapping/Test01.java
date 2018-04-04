package com.guofs.test.test04.mapping;

import com.guofs.test.test04.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: GuoFangshi
 * @Date: 2018/3/31 16:57
 */
@Slf4j
public class Test01 {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        Dish.fillList(menu);
        List<String> dishNames = menu.stream()
                .map(Dish :: getName)
                .collect(Collectors.toList());
        log.info(">>>>>>>>>>>>>>>>>>> 01 >>>>>>>>>>>>>>>>> {}", dishNames);
        System.out.println();

        List<String[]> letters01 = dishNames.parallelStream()
                .map(s -> s.split(""))
                .distinct()
                .collect(Collectors.toList());

        List<Stream> letters02 = dishNames.parallelStream()
                .map(s -> s.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String> letters03 = dishNames.parallelStream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        log.info(">>>>>>>>>>>>>>>>>>>>>> 2 >>>>>>>>>>>>>>>>>>>>>>>>>> {}", letters03);
        System.out.println();

        if (menu.parallelStream().anyMatch(Dish::isVegetarian)) {
            log.info(">>>>>>>>>>>>>>>>> 3 >>>>>>>>>>>>>>>>>>>>>>>>>>> The menu is (somewhat) vegetarian friendly!!");
            System.out.println();
        }

        if (menu.parallelStream().allMatch(d -> d.getCalories() < 1000)) {
            log.info(">>>>>>>>>>>>>>>>>>>>> 4 >>>>>>>>>>>>>>>>>>>>>>>>>>> all healthy");
            System.out.println();
        }

        if (menu.parallelStream().noneMatch(d -> d.getCalories() >= 1000)) {
            log.info(">>>>>>>>>>>>>>>>>>>>> 5 >>>>>>>>>>>>>>>>>>>>>>>>>>> all healthy");
            System.out.println();
        }

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> log.info(">>>>>>>>>>>>>>>>>>>>>>>>> 6 >>>>>>>>>>>>>>>>>>>>>>>>>>>> {} \n", dish.toString()));

        List<Integer> numbers = Arrays.asList(4, 5, 3, 1, 9, 22, 15, 3, 22, 1);
        numbers.stream()
                .reduce(Integer::sum)
                .ifPresent(integer -> log.info(">>>>>>>>>>>>>>>>>>>>>> 7 >>>>>>>>>>>>>>>>>>>>> {} \n", integer));
        numbers.stream()
                .reduce(Integer::max)
                .ifPresent(integer -> log.info(">>>>>>>>>>>>>>>>>>>>>> 8 >>>>>>>>>>>>>>>>>>>>> {} \n", integer));
    }
}
