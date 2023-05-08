package day07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        List<Integer> collect = list.stream().map(map -> {
            return map;
        }).sorted(Comparator.comparingInt(item -> item)).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(list);
    }
}
