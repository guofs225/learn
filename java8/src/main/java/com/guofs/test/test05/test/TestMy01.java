package com.guofs.test.test05.test;

import com.guofs.test.test05.transaction.Trader;
import com.guofs.test.test05.transaction.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Author: GuoFangshi
 * @Date: 2018/4/4 17:05
 */
public class TestMy01 {

    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");
    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        List<Transaction> practice01 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((transaction0, transaction1) -> (transaction0.getValue() - transaction1.getValue()))
                .collect(toList());
        System.out.println("practice01: " + practice01);
        List<String> practice02 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println("practice02: " + practice02);
    }
}
