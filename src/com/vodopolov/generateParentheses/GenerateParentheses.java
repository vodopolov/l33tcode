package com.vodopolov.generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton on 15.02.2020.
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses generator = new GenerateParentheses();
        generator.generateParenthesis(3);
        generator.generateParenthesis(2);
    }

    private List<String> generateParenthesis(int num) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, num);
        return result;
    }

    private void backtrack(List<String> result, String str, int open, int close, int max) {
        if ((open + close) == max * 2) {
            result.add(str);
            return;
        }
        if (open < max) backtrack(result, str + '(', open + 1, close, max);
        if (close < open) backtrack(result, str + ')', open, close + 1, max);
    }
}