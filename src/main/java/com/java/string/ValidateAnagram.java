package com.java.string;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ValidateAnagram {

    public static void main(String[] args) {
        String s1 = "CAT";
        String s2 = "ACT";

        System.out.println(anagram(s1, s2));
    }

    public static boolean anagram(String s1, String s2){

        if(s1.length() != s2.length()) return false;

        String sorted1 = s1.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .map(s -> String.valueOf(s))
                .collect(Collectors.joining());
        String sorted2 = s2.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return sorted1.equals(sorted2);
    }
}
