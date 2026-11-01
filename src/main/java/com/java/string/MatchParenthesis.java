package com.java.string;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Stack;

public class MatchParenthesis {
    public static void main(String[] args) {

        //String input = "()";
        //String input = "(}";
        //String input = "({[{}]})";
        String input = "[{)}]";
        System.out.println(match(input));

    }

    private static boolean match(String input){
        //if(!StringUtils.hasLength(input)) return false;
        //if(Objects.equals(input, "")) return  false;
        if(input.equals("")) return false;
        Stack<Character> stack = new Stack<Character>();

        for(char c : input.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }

            if(c == ')' || c == '}' || c == ']'){
                char pop = stack.pop();
                if((pop == '(' && c !=')')
                   ||(pop == '{' && c !='}')
                   || (pop == '[' && c !=']' )){
                    return false;
                }
            }
        }

      return stack.empty();
    }
}
