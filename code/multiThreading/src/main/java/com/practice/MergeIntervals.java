package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tania.gupta
 * @date 17/07/20
 */
public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(intervals);
    }

    private static int[] apply(Pair p) {
        return new int[]{p.getStart(), p.getEnd()};
    }

    public int[][] merge(int[][] intervals) {

        List<Pair> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(new Pair(interval[0], interval[1]));
        }

        Collections.sort(list, (a, b) -> a.getStart() - b.getStart());

        int index = 0;

        List<Pair> result = new ArrayList<>();
        result.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).getStart() <= result.get(result.size() - 1).getEnd()) {
                Pair previousPair = result.get(result.size() - 1);
                previousPair.end = Math.max(list.get(i).getEnd(), result.get(result.size() - 1).getEnd());
            } else
                result.add(list.get(i));
        }

        return result.stream().map(MergeIntervals::apply).toArray(int[][]::new);

    }
}

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}