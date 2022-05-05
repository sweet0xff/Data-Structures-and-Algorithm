package com.github.sweet.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2021/11/24 12:40
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        Trader trader1 = new Trader("zhangshan", "wuhan");
        Trader trader2 = new Trader("lisi", "wuhan");
        Trader trader3 = new Trader("wangwu", "wuhan");
        Trader trader4 = new Trader("zhaoliu", "shanghai");
        List<Transaction> list = Arrays.asList(
                new Transaction(trader4, 2011, 300),
                new Transaction(trader1, 2012, 1000),
                new Transaction(trader1, 2011, 400),
                new Transaction(trader2, 2012, 700),
                new Transaction(trader2, 2012, 200),
                new Transaction(trader3, 2011, 200)
        );
        List<String> city1 = list.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct().collect(Collectors.toList());
        city1.forEach(e -> System.out.println("e = " + e));

        Set<String> city2 = list.stream().map(transaction -> transaction.getTrader().getCity()).collect(Collectors.toSet());
        city2.forEach(e -> System.out.println("e = " + e));

        List<Trader> traders1 = list.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("wuhan"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        traders1.forEach(trader -> System.out.println("trader = " + trader.toString()));

        Optional<Integer> maxTrader = list.stream()
                .map(Transaction::getValue)
                .reduce(Math::max);
        System.out.println("maxTrader = " + maxTrader.get());

        Optional<Transaction> minTrader = list.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("minTrader = " + minTrader.get());


    }
}
