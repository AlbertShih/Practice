package questions.practice;

class LargestString {
    /*
    https://www.geeksforgeeks.org/lexicographically-largest-string-possible-consisting-of-at-most-k-consecutive-similar-characters/
    */// Function to find largest string, O(n)
    static String largestString(String S, int limit) {
        int[] alphaCnt = new int[26];
        for (char c : S.toCharArray()) {
            alphaCnt[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        /*boolean terminate = false;*/
        for (int i = alphaCnt.length - 1; i >= 0 /*&& !terminate*/; i--) {
            int cnt = 0;
            while (alphaCnt[i] > 0 /*&& !terminate*/) {
                if (cnt < limit) {
                    sb.append((char) (i + 'a'));
                    alphaCnt[i]--;
                    cnt++;
                } else {
                    // reach the limit so we insert next alphabet
                    /*terminate = true;*/
                    for (int j = i - 1; j >= 0; j--) {
                        if (alphaCnt[j] > 0) {
                            sb.append((char) (j + 'a'));
                            alphaCnt[j]--;
                            cnt = 0;
                            /*terminate = false;*/
                            break;
                        }
                    }
                    if (cnt != 0) {
                        return sb.toString();
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        class TestCase {
            String S;
            int K;

            public TestCase(String s, int k) {
                S = s;
                K = k;
            }
        }
        TestCase[] testCases = new TestCase[3];
        testCases[0] = new TestCase("ccbbb", 2);
        testCases[1] = new TestCase("zzzazz", 2);
        testCases[2] = new TestCase("axxzzx", 2);
        for (TestCase testCase : testCases) {
            System.out.println(largestString(testCase.S, testCase.K));
        }
        /*Ans:
        ccbb
        zzazz
        zzxxax
        */
    }
}
