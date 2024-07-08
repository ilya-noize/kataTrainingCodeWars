package com.codewars.kata.training;

import java.util.Stack;

/**
 * "(){}[]"   =>  True  <br/>
 * "([{}])"   =>  True  <br/>
 * "(}"       =>  False <br/>
 * "[(])"     =>  False <br/>
 * "[({})](]" =>  False <br/>
 */
public class BraceChecker {

    public boolean isValid(String string) {
        popularSolution(string);
        return mySolution(string);
    }

    /**
     * ASCII-codes
     * <p>
     * 40 = (,
     * 41 = ),
     * 91 = [,
     * 93 = ],
     * 123 = {,
     * 125 = };
     */
    private boolean mySolution(String string) {
        int length = string.length();
        char[] deque = new char[length];
        int index = 0;

        if (length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            if (c == 40 || c == 91 || c == 123) {
                deque[index] = c;
                index++;
            } else if (i == 0 || index == 0) {
                return false;
            } else if (c == 41 && deque[index - 1] == 40) {
                deque[index - 1] = 0;
                index--;
            } else if (c == 93 && deque[index - 1] == 91) {
                deque[--index] = 0;
            } else if (c == 125 && deque[index - 1] == 123) {
                deque[--index] = 0;
            } else return false;
        }
        return deque[0] == 0;
    }

    public boolean popularSolution(String braces) {
        Stack<Character> s = new Stack<>();
        for (char c : braces.toCharArray())
            if (!s.isEmpty() && isClosing(s.peek(), c)) {
                s.pop();
            } else {
                s.push(c);
            }
        return s.isEmpty();
    }

    private boolean isClosing(char x, char c) {
        return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
    }
}
