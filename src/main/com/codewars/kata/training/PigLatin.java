package com.codewars.kata.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
 * <p>
 *
 * simple solution:<br/>
 * 1) str.replaceAll("(\\w)(\\w*)", "$2$1ay");<br/>
 * 2) PATTERN.matcher(string).replaceAll("$2$1ay");<br/>
 */
public class PigLatin {
    public static final String REGEX = "(\\w)(\\w+)";
    public static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final String POSTFIX = "ay";

    private PigLatin() {
    }

    /**
     * Move the first letter of each word to the end of it, then add "ay" to the end of the word.<br/>
     * Leave punctuation marks untouched.
     * @param string incoming string
     * @return result
     */
    public static String pigIt(String string) {
        Matcher matcher = PATTERN.matcher(string);
        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            String word = matcher.group();
            matcher.appendReplacement(builder,
                    word.substring(1)
                            + word.charAt(0)
                            + POSTFIX);
        }

        return matcher.appendTail(builder).toString();
    }
}
