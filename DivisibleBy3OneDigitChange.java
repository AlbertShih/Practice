package questions.practice;

import java.util.HashSet;
import java.util.Set;

//how many numbers divisible by 3 can be obtained with at most one change of a digit
//https://cloudstack.ninja/omar-ayman/how-many-numbers-divisible-by-3-can-be-obtained-with-at-most-one-change-of-a-digit/
public class DivisibleBy3OneDigitChange {
    public static int solution(String S) {

        int sum = 0;
        for (Character c : S.toCharArray()) {
            sum += c - '0';
        }

        char[] chars = S.toCharArray();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            int diff = (sum - (chars[i] - '0')) % 3;
            if (diff == 0) {
                char temp = chars[i];
                chars[i] = '0';
                set.add(String.valueOf(chars));
                chars[i] = '3';
                set.add(String.valueOf(chars));
                chars[i] = '6';
                set.add(String.valueOf(chars));
                chars[i] = '9';
                set.add(String.valueOf(chars));
                chars[i] = temp;
            } else if (diff == 2) {
                char temp = chars[i];
                chars[i] = '1';
                set.add(String.valueOf(chars));
                chars[i] = '4';
                set.add(String.valueOf(chars));
                chars[i] = '7';
                set.add(String.valueOf(chars));
                chars[i] = temp;
            } else if (diff == 1) {
                char temp = chars[i];
                chars[i] = '2';
                set.add(String.valueOf(chars));
                chars[i] = '5';
                set.add(String.valueOf(chars));
                chars[i] = '8';
                set.add(String.valueOf(chars));
                chars[i] = temp;
            }
        }

        return set.size();
    }

    public static int solution2(String S) {
        int sum = 0;
        for (Character c : S.toCharArray()) {
            sum += c - '0';
        }
        int ans = 0;
        for (Character c : S.toCharArray()) {
            int diff = (sum - (c - '0')) % 3;
            if (diff == 0) {
                ans += 4;
            } else {
                ans += 3;
            }
        }
        // System.out.println(ans);
        if (sum % 3 == 0) {
            ans -= (S.length() - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution2("23")); // 7
        System.out.println(solution2("0081")); // 11
        System.out.println(solution2("022")); // 9

        System.out.println(solution("3223003"));
        System.out.println(solution2("3223003"));
        System.out.println(solution("234593"));
        System.out.println(solution2("234593"));
    }
}
