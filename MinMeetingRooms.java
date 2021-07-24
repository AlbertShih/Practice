package questions.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

//LC253. Meeting Rooms II
public class MinMeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {
        /*intervals =
                Arrays.stream(intervals)
                        .sorted(Comparator.comparingInt(x -> x[0]))
                        .toArray(int[][]::new);*/
        //Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        /*Arrays.sort(intervals, Comparator.comparingInt(new ToIntFunction<int[]>() {
            @Override
            public int applyAsInt(int[] ints) {
                return ints[0];
            }
        }));*/
        Arrays.sort(intervals, Comparator.comparing(new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] ints) {
                return ints[0];
            }
        }));
        //System.out.println(Arrays.deepToString(intervals));

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(interval[1]);
            } else {
                if (interval[0] >= minHeap.peek()) {
                    minHeap.poll();
                }
                minHeap.offer(interval[1]);
            }
        }

        return minHeap.size();
    }

    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][] {new int[] {0, 30}, new int[] {15, 20}, new int[] {5, 10}}));
        System.out.println(minMeetingRooms(new int[][] {new int[] {7, 10}, new int[] {2, 4}}));
    }
}
