package codewars.com.kata.training;

public class SplitStrings {
    private SplitStrings() {
    }

    public static String[] solution(String s) {
        int arraySize = s.length() / 2;
        if (s.length() % 2 == 1) {
            s += "_";
            arraySize++;
        }
        String[] stringList = new String[arraySize];
        for (int i = 0; i < s.length(); i += 2) {
            stringList[i / 2] = s.substring(i, i + 2);
        }
        return stringList;
    }
}

//0 1 2 3 4 5 6 7 8 9 1 1 2 3 4 5 6 7 8 9 2
//0   1   2   3   4   5   6   7   8   9   1
