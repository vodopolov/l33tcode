package com.vodopolov.validParentheses;

import java.util.Stack;

/**
 * Created by Anton on 09.02.2020.
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        String test1 = "()";
        String test2 = "()[]{}";
        String test3 = "(]";
        String test4 = "([)]";
        String test5 = "{[]}";

        ValidParenthesis validator = new ValidParenthesis();
        System.out.println(test1 + " validation result is: " + validator.isValid(test1));
        System.out.println(test2 + " validation result is: " + validator.isValid(test2));
        System.out.println(test3 + " validation result is: " + validator.isValid(test3));
        System.out.println(test4 + " validation result is: " + validator.isValid(test4));
        System.out.println(test5 + " validation result is: " + validator.isValid(test5));
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {

                if (s.charAt(i) == ')' && stack.size() > 0 && stack.lastElement() == '(')
                    stack.pop();
                else if (s.charAt(i) == '}' && stack.size() > 0 && stack.lastElement() == '{')
                    stack.pop();
                else if (s.charAt(i) == ']' && stack.size() > 0 && stack.lastElement() == '[')
                    stack.pop();
                else return false;
            }
        }
        return stack.size() == 0;
    }
}
