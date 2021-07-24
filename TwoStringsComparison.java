package questions.practice;// Working program using Scanner

import java.util.Stack;

public class TwoStringsComparison {

    public static boolean compare(String a, String b) {
        Stack<Character> st1 = new Stack<>();
        for (char c : a.toCharArray()) {
            if (c == '!' && st1.size() > 0) {
                st1.pop();
                continue;
            } else if (c == '!') {
                continue;
            }
            st1.add(c);
        }

        Stack<Character> st2 = new Stack<>();
        for (char c : b.toCharArray()) {
            if (c == '!' && st2.size() > 0) {
                st2.pop();
                continue;
            } else if (c == '!') {
                continue;
            }
            st2.add(c);
        }

        return st1.toString().equals(st2.toString());
    }

    private static char[] reverse(char[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            char tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
        return a;
    }

    public static boolean compare2(String a, String b) {
        char[] charsA = reverse(a.toCharArray());
        char[] charsB = reverse(b.toCharArray());
        System.out.println(charsA);
        System.out.println(charsB);

        int sizeA = process2(charsA);
        int sizeB = process2(charsB);

        System.out.println(sizeA);
        System.out.println(sizeB);
        System.out.println(charsA);
        System.out.println(charsB);

        if (sizeA != sizeB) {
            return false;
        }

        for (int i = 0; i < sizeA; i++) {
            if (charsA[i] != charsB[i]) {
                return false;
            }
        }
        return true;
    }

    private static char[] swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
        return chars;
    }
    // abc!!abc
    // abc
    //   l
    //       r
    // Error prone
    private static int process2(char[] chars) {
        int l = 0, r = 0, cnt = 0;
        while (r < chars.length) {
            if (chars[r] == '!') {
                cnt++;
                r++;
            }
            while (cnt-- > 0) {
                r++;
            }
            if (r >= chars.length) break;

            swap(chars, r, l);
            l++;
            r++;
        }
        return l;
    }

    //
    //    //a!!bc
    //    //   bc
    //    //
    //    cnt

    public static boolean compare3(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        System.out.println(charsA);
        System.out.println(charsB);
        int aIndex = charsA.length - 1, bIndex = charsB.length - 1, aSkipCnt = 0, bSkipCnt = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            System.out.println("a" + aIndex + ";b" + bIndex);
            while (aIndex >= 0 && charsA[aIndex] == '!') {
                aSkipCnt++;
                aIndex--;
            }
            while (aSkipCnt-- > 0) {
                aIndex--;
            }
            while (bIndex >= 0 && charsB[bIndex] == '!') {
                bSkipCnt++;
                bIndex--;
            }
            while (bSkipCnt-- > 0) {
                bIndex--;
            }
            if (aIndex >= 0 && bIndex >=0 && charsA[aIndex] != charsB[bIndex]) {
                return false;
            }
            aIndex--;
            bIndex--;
        }

        while (aIndex >= 0) {
            if (charsA[aIndex] != '!') return false;
            aIndex--;
        }

        while (bIndex >= 0) {
            if (charsB[bIndex] != '!') return false;
            bIndex--;
        }

        return true;
    }

    public static void main(String[] args) {
        {
            String a = "abc!";
            String b = "!abc";
            System.out.println(compare3(a, b));
        }
        System.out.println();
        {
            String a = "!!abcc!!";
            String b = "!!ab";
            System.out.println(compare3(a, b));
        }
    }
}
