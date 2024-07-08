package com.codewars.kata.olimpic.coupleofletters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class CoupleOfLetters {
    /*
	Для чтения входных данных необходимо получить их
	из стандартного потока ввода (System.in).
	Данные во входном потоке соответствуют описанному
	в условии формату. Обычно входные данные состоят
	из нескольких строк. Можно использовать более производительные
	и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

	С помощью BufferedReader можно прочитать из стандартного потока:
	* строку -- reader.readLine()
	* число -- int n = Integer.parseInt(reader.readLine());
	* массив чисел известной длины (во входном потоке каждое число на новой строке) --
	int[] nums = new int[len];
    for (int i = 0; i < len; i++) {
        nums[i] = Integer.parseInt(reader.readLine());
    }
	* последовательность слов в строке --
	String[] parts = reader.readLine().split(" ");

	Чтобы вывести результат в стандартный поток вывода (System.out),
	Через BufferedWriter можно использовать методы
	writer.write("Строка"), writer.write('A') и writer.newLine().

	Возможное решение задачи "Вычислите сумму чисел в строке":
	int sum = 0;
    String[] parts = reader.readLine().split(" ");
    for (int i = 0; i < parts.length; i++) {
        int num = Integer.parseInt(parts[i]);
        sum += num;
    }
    writer.write(String.valueOf(sum));
	*/

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] //words = reader.readLine().trim().split("/w+ ");
        words = "qwer qwer wer er er erty".trim().split("/w+ ");
        Map<String, Integer> counterCoupleOfLettersStore = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            if (length >= 2) {
                for (int i = 0; i < length; i++) {
                    if (i + 2 > length) break;

                    String coupleOfLetters = word.trim().substring(i, i + 2).trim();
                    if(coupleOfLetters.length() == 2) {
                        System.out.println("+= " + coupleOfLetters);

                        if (counterCoupleOfLettersStore.containsKey(coupleOfLetters)) {
                            int counter = counterCoupleOfLettersStore.get(coupleOfLetters);
                            counterCoupleOfLettersStore.replace(coupleOfLetters, ++counter);
                            System.out.println(coupleOfLetters + " => " + counter);
                        } else {
                            counterCoupleOfLettersStore.put(coupleOfLetters, 1);
                        }
                    }
                }
            }
        }

        counterCoupleOfLettersStore.forEach(
                (key, value) -> {
                    try {
                        writer.write("«" + key + "» => «" + value + "»\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        reader.close();
        writer.close();
    }
}
