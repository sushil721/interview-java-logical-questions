package com.java.string;

import java.util.*;
import java.util.stream.Collectors;

public class AllAnagramInList {

    public static void main(String[] args) {
      //  String input = "cat,dog,god,ast,ogd,gdo,sat,tas,tac,surendra";
        // output: [[cat,tac],[dog,gdo,god,ogd],[ast,sat,tas]]
        String input = "test,stte,local,calol";

        System.out.println(findAllAnagram(input));
        //IO.println(logic(input));
    }

    public static List<List<String>> findAllAnagram(String input) {
        List<String> list = Arrays.asList(input.split(","));
        Map<String, List<String>> map = new LinkedHashMap<>();

        for (String str : list) {
            String sorted = str.chars()
                    .mapToObj(c -> (char) c)
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            map.computeIfAbsent(sorted, key -> new ArrayList<>()).add(str);
        }
      //  IO.println(map);
        return map.values().stream()
                .filter(group -> group.size() > 1)
                .collect(Collectors.toList());
    }
    /*
    public static  List<Map.Entry<String, List<String>>> logic(String input){

     List<String> list = Arrays.asList(input.split(""));

        List<Map.Entry<String, List<String>>> collect = list.stream()
                .collect(Collectors.groupingBy(
                        str -> str.chars()
                                .sorted()
                                .mapToObj(c -> String.valueOf((char) c))
                                .map(String::valueOf)
                                .collect(Collectors.joining())))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toList());

    return collect;
    }
*/
}
