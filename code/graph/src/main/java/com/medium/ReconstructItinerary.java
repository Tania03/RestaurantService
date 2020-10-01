package com.medium;

import java.util.*;

/**
 * @author tania.gupta
 * @date 28/06/20
 */
public class ReconstructItinerary {

    public static void main(String[] args) {

        Flight flight = new Flight();
//[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "LHR"]]
        List<String> list1 = new ArrayList<>();
        list1.add("MUC");
        list1.add("LHR");
        List<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("MUC");
        List<String> list3 = new ArrayList<>();
        list3.add("SFO");
        list3.add("SJC");
        List<String> list4 = new ArrayList<>();
        list4.add("LHR");
        list4.add("SFO");
//        List<String> list5 = new ArrayList<>();
//        list5.add("ATL");
//        list5.add("SFO");

        List<List<String>> maiList = new ArrayList<>();
        maiList.add(list1);
        maiList.add(list2);
        maiList.add(list3);
        maiList.add(list4);
//        maiList.add(list5);
        flight.findItinerary(maiList);
    }
}

class Flight {

    public List<String> findItinerary(List<List<String>> tickets) {

        final String start = "JFK";

        List<String> result = new ArrayList<>();

        HashMap<String, PriorityQueue<String>> flights = new HashMap<>();

        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        Stack<String> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {

            while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty())
                stack.add(flights.get(stack.peek()).poll());

            result.add(0, stack.pop());

        }


        System.out.println(result);
        return result;

    }

}