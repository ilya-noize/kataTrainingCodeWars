package com.codewars.kata.olimpic.busstops.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static com.codewars.kata.olimpic.busstops.utils.ArrayUtils.sortAscendingOrder;

/**
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
<hr>
# Example <br/>
## IN   <br/>
3 2     <br/>
1 3 5   <br/>
4 1     <br/>

## OUT  <br/>
2       <br/>
1       <br/>

 */
public class BusStopAsync {

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

        for (int bus : buses) {
            NearestStopsThread thread = new NearestStopsThread(busStops, bus, writer);
            thread.run();
        }

        reader.close();
        writer.close();
    }
}