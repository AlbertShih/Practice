package questions.practice;

import java.util.*;

public class SubStringContainsAllChars {
    // https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
    // Sliding window solution
    //    Complexity Analysis:
    //    Time Complexity: O(N).
    //    As the string is traversed using two pointers only once.
    //    Space Complexity: O(N).
    //    As a hash_map is used of size N
    static String findSubString(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        int distinctCnt = set.size();

        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int ansLen = Integer.MAX_VALUE;
        int ansStartIdx = 0;

        // try to move the right ptr
        for (int r = 0; r < str.length(); r++) {
            map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);
            while (map.size() == distinctCnt) {
                // try to move the left ptr
                if (map.get(str.charAt(l)) - 1 == 0) {
                    // means the substring doesn't contain all chars anymore, don't move. Just
                    // record the ans before moving
                    if (r - l + 1 < ansLen) {
                        ansLen = r - l + 1;
                        ansStartIdx = l;
                    }
                    break;
                } else {
                    map.put(str.charAt(l), map.get(str.charAt(l)) - 1);
                    l++;
                }
            }
            // System.out.println("l=" + l + ";r="+r);
        }

        return str.substring(ansStartIdx, ansStartIdx + ansLen);
    }

    public static void main(String[] args) {
        {
            String str = "aabcbcdbca";
            System.out.println(
                    "Smallest window containing all distinct"
                            + " characters is: "
                            + findSubString(str));
        }
        {
            String str = "abcdabccdabcccd";
            System.out.println(
                    "Smallest window containing all distinct"
                            + " characters is: "
                            + findSubString(str));
        }
        {
            String str = "a";
            System.out.println(
                    "Smallest window containing all distinct"
                            + " characters is: "
                            + findSubString(str));
        }
        {
            String str = "aaaa";
            System.out.println(
                    "Smallest window containing all distinct"
                            + " characters is: "
                            + findSubString(str));
        }
        {
            String str = "abcabcabcabcdabc";
            System.out.println(
                    "Smallest window containing all distinct"
                            + " characters is: "
                            + findSubString(str));
        }
    }
}
