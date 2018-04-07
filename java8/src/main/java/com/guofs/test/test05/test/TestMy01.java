package com.guofs.test.test05.test;

import com.guofs.test.test05.transaction.Trader;
import com.guofs.test.test05.transaction.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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
        Set<String> practice02 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
        System.out.println("practice02: " + practice02);
        List<Trader> practice03 = transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(toList());
        System.out.println("practice03: " + practice03);
        String practice04 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println("practice04: " + practice04);

        Trader practice05 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Milan".equals(trader.getCity()))
                .findAny()
                .orElse(new Trader("no people", "Milan"));
        System.out.println(practice05);

        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println();
        transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .ifPresent(System.out::println);

        System.out.println();

        transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .ifPresent(System.out::println);

        System.out.println();

        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}
