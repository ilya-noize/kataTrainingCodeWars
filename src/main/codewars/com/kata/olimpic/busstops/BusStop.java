package codewars.com.kata.olimpic.busstops;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*


Если автобус имеет координату x, то выбирается номер остановки i, минимизирующий
∣𝑎𝑖–𝑥∣. Если таких 𝑖 несколько, то выбирать номер нужно остановки по правилам:

- Если есть остановки, совпадающие с координатой автобуса, то стоит вывести минимальную по номеру среди них.
- Если есть остановки справа и слева, то стоит вывести максимальную по номеру среди левых.
- Если есть остановки только слева, то стоит вывести максимальную по номеру среди левых.
- Если есть остановки только справа, то стоит вывести минимальную по номеру среди правых.


В примере даны остановки с координатами
1,3,5.

Для первого запроса автобус находится в точке 4 и расстояния
до остановок от него равны 3,1,1 соответственно:
- Это значит, что существуют оптимальные остановки
слева (остановка с номером 2) и
справа (остановка с номером 3), а значит нужно выбрать
максимальную по номеру среди левых - 2.

- Во время второго запроса автобус находится в точке 1,
а значит существует всего одна остановка,
минимизирующая заданное расстояние = 0.

 */
public class BusStop {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] config = reader.readLine().trim().split(" ");
        String[] lineBusStop = reader.readLine().trim().split(" ");
        String[] lineBus = reader.readLine().trim().split(" ");

        int numberStops = Integer.parseInt(config[0]);
        int[] busStops = new int[numberStops];
        for (int i = 0; i < numberStops; i++) {
            busStops[i] = Integer.parseInt(lineBusStop[i]);
        }

        int numberBuses = Integer.parseInt(config[1]);
        int[] buses = new int[numberBuses];
        for (int i = 0; i < numberBuses; i++) {
            buses[i] = Integer.parseInt(lineBus[i]);
        }

        sortAscendingOrder(busStops, numberStops);

        int[] nearestStops = getNearestStops(busStops, buses);

        for (int i : nearestStops) {
            writer.write(i + "\n");
        }

        reader.close();
        writer.close();
    }

    public static int[] getNearestStops(int[] busStops,
                                        int[] buses) {

        int numberStops = busStops.length;

        int numberBuses = buses.length;
        int[] nearestStops = new int[numberBuses];
        for (int numberBus = 0; numberBus < numberBuses; numberBus++) {

            int bus = buses[numberBus];

            if (numberBus == 0) {
                nearestStops[numberBus] = getNearestStop(
                        busStops,
                        numberStops,
                        bus
                );
            } else {
                for (int i = 0; i < numberBus; i++) {
                    int nextBus = buses[i];
                    if (nextBus == bus) {
                        nearestStops[numberBus] = nearestStops[i];
                        break;
                    }
                }
                if (nearestStops[numberBus] == 0) {
                    nearestStops[numberBus] = getNearestStop(
                            busStops,
                            numberStops,
                            bus
                    );
                }
            }
        }

        return nearestStops;
    }

    public static void showArray(int[] busStops) {
        int numberStops = busStops.length;
        System.out.println();
        System.out.printf("int[] busStopSort = /* %d */{%n", numberStops);
        String format = "  %d => %d,%n";
        for (int i = 0; i < numberStops; i++) {
            if (i + 1 == numberStops) format = "  %d => %d";
            System.out.printf(format, i + 1, busStops[i]);
        }
        System.out.println("};");
    }

    private static int getNearestStop(int[] busStops, int numberStops, int bus) {
        int index = numberStops;
        int busStop = busStops[index - 1];
        int distance = Math.abs(bus - busStop);

        if (distance != 0) {
            for (int numberStop = numberStops - 2; numberStop >= 0; numberStop--) {

                busStop = busStops[numberStop];

                int currentDistance = Math.abs(bus - busStop);

                if (distance >= currentDistance) {
                    if (numberStop != 0) {
                        distance = currentDistance;
                        index = numberStop;
                    } else {

                        return numberStop + 1;
                    }
                } else {

                    return index + 1;
                }
            }
        }

        return index;
    }

    public static int[] sortAscendingOrder(int[] a, int size) {
        int[] seq = new int[40];
        int s;

        // вычисление последовательности приращений
        s = increment(seq, size);
        while (s >= 0) {
            // сортировка вставками с инкрементами inc[]
            int inc = seq[s--];

            for (int i = inc; i < size; i++) {
                try {
                    int temp = a[i];
                    int j;
                    for (j = i - inc; (j >= 0) && (a[j] > temp); j -= inc) {
                        a[j + inc] = a[j];
                    }
                    a[j + inc] = temp;
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    break;
                }
            }
        }
        return a;
    }

    private static int increment(int[] inc, int size) {
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        int s = -1;

        do {
            if ((++s % 2) > 0) {
                inc[s] = 8 * p1 - 6 * p2 + 1;
            } else {
                inc[s] = 9 * p1 - 9 * p3 + 1;
                p2 *= 2;
                p3 *= 2;
            }
            p1 *= 2;
        } while (3 * inc[s] < size);

        return s > 0 ? --s : 0;
    }
}
