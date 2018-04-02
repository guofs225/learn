package com.guofs.test.test04.mapping;

import com.guofs.test.test04.Dish;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    }
}
