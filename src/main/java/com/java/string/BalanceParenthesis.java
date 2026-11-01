package com.java.string;

import org.springframework.util.StringUtils;

import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) {

        //String input = "()";
        //String input = "(}";
        //String input = "({[{}]})";
        //String input = "[{)}(]";
        String input  ="[[]{)}(]";  //[[]{}()] // [ [{()}] ]
        System.out.println(balance(input));

    }

    public static String balance(String input){
        //if(!StringUtils.hasLength(input)) return "Input should be non-empty string";
        //if(Objects.equals(input, "")) return  "Input should be non-empty string";
        if(input.equals("")) return "Input should be non-empty string";

        Stack<Character> stack = new Stack<Character>();
        StringBuilder result = new StringBuilder();
        for(char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
        }
        char pop = stack.pop();
        for(char c: input.toCharArray()){

                if (pop == '(' && c == ')') {
                    result.append(pop).append(c);
                    pop = stack.pop();
                } else if (pop == '{' && c == '}') {
                    result.append(pop).append(c);
                    pop = stack.pop();
                } else if (pop == '[' && c == ']') {
                    result.append(pop).append(c);
                }
            }
          //System.out.println(result);
        return result.toString();
    }
}
