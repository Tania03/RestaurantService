package com.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author tania.gupta
 * @date 26/06/20
 */
public class CheapestFlightWithinKStops {

    public static void main(String[] args) {

        CheapestFlightWithinKStops c = new CheapestFlightWithinKStops();

        Solution s = new Solution();
        int minSum = s.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 50}}, 0, 2, 2);
        System.out.println(minSum);

    }
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        if (flights == null || flights.length == 0 || K == 0)
            return -1;

        FlightGraph flightGraph = new FlightGraph(n, flights);

        if (flightGraph.connections[src].size() == 0)
            return -1;

        Queue<City> queue = new PriorityQueue<>((c1, c2) -> c1.priceFromSrc - c2.priceFromSrc);
        queue.add(new City(src, 0, 0));

        while (!queue.isEmpty()) {

            City top = queue.poll();

            if (top.src == dst)
                return top.priceFromSrc;

            if (top.destFromSrc > K)
                continue;

            List<Pair> neighbours = flightGraph.connections[top.src];
            for (Pair neighbour : neighbours) {
                queue.add(new City(neighbour.city, top.destFromSrc + 1, top.priceFromSrc + neighbour.price));
            }

        }

        return -1;

    }


}

class City {

    int src, destFromSrc, priceFromSrc;

    City(int src, int destFromSrc, int priceFromSrc) {
        this.src = src;
        this.destFromSrc = destFromSrc;
        this.priceFromSrc = priceFromSrc;
    }
}

class Pair {

    int city, price;

    Pair(int city, int price) {
        this.city = city;
        this.price = price;
    }

}

class FlightGraph {

    int stops;
    List<Pair>[] connections;

    FlightGraph(int stops, int[][] flights) {
        this.stops = stops;
        this.connections = new ArrayList[stops];

        for (int i = 0; i < stops; i++) {
            connections[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            connections[flight[0]].add(new Pair(flight[1], flight[2]));
        }

    }

}