package com.java.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class CountAllTypesOfBalanceParenthesis {
    public static void main(String[] args) {
        String input = "[][]{}()";
        System.out.println(balance(input));
    }

    public static Map<String, Integer> balance(String input) {
        if (input == null || input.isEmpty()) {
            return new LinkedHashMap<>();
        }

        Map<String, Integer> result = new LinkedHashMap<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
               stack.push(ch);
               continue;
            }

            if ((ch == ')' || ch == '}' || ch == ']') && !stack.isEmpty()) {
               char open = stack.peek();
               if ((open == '(' && ch == ')')
                       || (open == '{' && ch == '}')
                       || (open == '[' && ch == ']')) {
                   stack.pop();
                   String pair = String.valueOf(open) + ch;
                   result.put(pair, result.getOrDefault(pair, 0) + 1);
               }
            }
        }

        return result;
    }

}
