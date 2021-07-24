package questions.practice;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class MinimumBribes {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        for (int i = 0; i < q.size(); i++) {
            int n = q.get(i) - 1 - i;
            if (n > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int sum = 0;
        while (true) {
            int move = 0;
            for (int i = 0; i < q.size() - 1; i++) {
                if (q.get(i) > q.get(i + 1)) {
                    // swap
                    int tmp = q.get(i);
                    q.set(i, q.get(i + 1));
                    q.set(i + 1, tmp);
                    move += 1;
                }
            }

            if (move == 0) {
                break;
            }
            sum += move;
        }
        System.out.println(sum);
    }
}

// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class HackRank {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t)
                .forEach(
                        tItr -> {
                            try {
                                int n = Integer.parseInt(bufferedReader.readLine().trim());

                                List<Integer> q =
                                        Stream.of(
                                                        bufferedReader
                                                                .readLine()
                                                                .replaceAll("\\s+$", "")
                                                                .split(" "))
                                                .map(Integer::parseInt)
                                                .collect(toList());

                                MinimumBribes.minimumBribes(q);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });

        bufferedReader.close();
    }
}
