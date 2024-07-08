package codewars.com.kata.olimpic.twoteams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TwoTeams {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        task422TwoTeams(reader, writer);

        reader.close();
        writer.close();
    }

    /**
     * Студенты, разбившись на две команды, решали контест по программированию.
     * Каждый студент решил не менее 1 и не более 𝑁 задач.
     * Известно, что первая команда суммарно решила 𝐴 задач, а вторая — 𝐵 задач.
     * <p>
     * Определите, могло ли быть в первой команде больше студентов, чем во второй.
     * <p>
     * Формат ввода
     * Каждый тест состоит из трёх строк, где вводятся параметры теста, каждый в отдельной строке, —
     * 𝐴     * 0 ≤ 𝐴
     * 𝐵     * 𝐵 ≤ 10000
     * 𝑁     * 1 ≤ 𝑁 ≤ 10000
     * A,B,N(0≤A,B≤10000,1≤N≤10000).
     * <p>
     * Формат вывода
     * Выведите Yes, если в первой команде могло быть больше студентов, чем во второй, и No в противном случае.
     * <p>
     * Примечание
     * В первом тесте студенты первой команды решили
     * 10 задач суммарно,
     * а студенты второй команды решили 8 задач суммарно.
     * В первой команде могло быть 10 студентов, решивших по одной задаче,
     * а во второй команде всего 8 студентов, решивших по одной задаче, поэтому ответ Yes.
     * <p>
     * Во втором тесте студенты первой команды решили 3 задачи,
     * а вторая команда решила 10 задач.
     * Учитывая, что каждый студент решил не более 3 задач,
     * второй команде нужно было как минимум 4 студента.
     * А значит, в ней точно больше студентов, чем в первой команде, и ответ No.
     */
    private static void task422TwoTeams(BufferedReader reader, BufferedWriter writer) throws IOException {
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        if (isA(a, b, n)) {
            writer.write("Yes");
        } else {
            writer.write("No");
        }
    }

    public static boolean isA(int a, int b, int n) throws IOException {
        if(isInvalid(a, b, n)) {
            throw new IOException();
        }

        int teamA = a / n;
        int teamB = b / n;

        if (a % n > 0) teamA++;
        if (b % n > 0) teamB++;

        return teamA > teamB;
    }

    private static boolean isInvalid(int a, int b, int n) {
        return a < 0 || b > 10000 || (n < 1 || n > 10000);
    }
}
