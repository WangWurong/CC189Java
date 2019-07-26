import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraysAndStrings {
    /**
     * Q1.1
     * for string, considering the unicode/ascii, the number of chars is at most:
     * char set of ASCII. only 128 7 bits
     * char set of extend ASCII, 256 8 bits
     * char set of Unicode, 16 bits
     * byte, short int and long represent 8, 16, 32, 64 bit
     * using integer as the bit set
     * check position is 1:
     * @param s
     * @return
     */
    public boolean isUnique(String s) {
        int bitSet = 0;
        for (char c : s.toCharArray()) {
            int num = (int)c;
            // retrieve the position value and set
            if ((bitSet & (1 << num)) != 0) {
                return false;
            }
            bitSet |= (1 << num);
        }
        return true;
    }

    /**
     * Q1.2
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();
        for (char c1 : s1.toCharArray()) {
            count.put(c1, count.getOrDefault(c1, 0) + 1);
        }
        for (char c2 : s2.toCharArray()) {
            if (!count.containsKey(c2)) {
                return false;
            } else {
                int tempCnt = count.get(c2);
                if (tempCnt == 1) {
                    count.remove(c2);
                } else {
                    count.put(c2, tempCnt - 1);
                }
            }
        }
        return count.isEmpty();
    }

    /**
     * Q1.3
     * update inplace, get the final length and update from that
     * @param input
     * @param len
     * @return
     */
    public char[] URLify(char[] input, int len) {
        int spaceCount = getSpaceCount(input, len);
        int finalLen = len + spaceCount * 2; // 1 space for 2 more chars
        int i = finalLen, j = len;
        while (i >= 0 && j >= 0) {
            if (input[j] == ' ') {
                input[i] = '0';
                input[i - 1] = '2';
                input[i - 2] = '%';
                i -= 3;
            } else {
                input[i] = input[j];
                i--;
            }
            j--;
        }
        return input;
    }

    private int getSpaceCount(char[] input, int len) {
        int cnt = 0;
        for (int i = len; i >= 0; i--) {
            if (input[i] == ' ') {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * Q1.4
     * Skip non-letter and ignore case
     * go through the string, check if it is letter
     * store in lowercase
     * better to use array instead of hashtable
     * @param s
     * @return
     */
    public boolean isPalindromePermutation(String s) {
        int oddCount = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char lc = Character.toLowerCase(c);
                count.put(lc, count.getOrDefault(lc, 0) + 1);
                int curCnt = count.get(lc);
                if (curCnt % 2 == 1) {
                    oddCount++;
                } else {
                    oddCount--;
                }
            }
        }

        return oddCount <= 1;
    }

    /**
     * Q1.5
     * compare the length. and there should be only one diff
     * let c1.length <= c2.length
     * @param s1
     * @param s2
     * @return
     */
    public boolean oneWay(String s1, String s2) {
        char[] c1 = s1.length() > s2.length() ? s2.toCharArray() : s1.toCharArray();
        char[] c2 = s1.length() > s2.length() ? s1.toCharArray() : s2.toCharArray();

        boolean metDiff = false;
        int i = 0, j = 0;
        while (i < c1.length && j < c2.length) {
            if (c1[i] != c2[j]) {
                if (metDiff) {
                    return false;
                } else if (c1.length == c2.length) {
                    metDiff = true;
                } else {
                    j++;
                    metDiff = true;
                }
            }
            i++;
            j++;
        }
        return true;
    }

    /**
     * Q1.6
     * only use i is enough, no need to use two pointers
     * @param s
     * @return
     */
    public String stringCompression(String s) {
        // to save the space, we can add one more function to check whether it need to be compress
        int compressedLen = getCompressLen(s);
        if (s.length() <= compressedLen) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        char last = s.charAt(0);
        int cnt = 0;
        while (i < s.length()) {
            if (s.charAt(i) != last) {
                sb.append(last);
                sb.append(cnt);
                cnt = 1;
                last = s.charAt(i);
            } else {
                cnt++;
            }
            i++;
        }
        sb.append(last);
        sb.append(cnt);
        return sb.toString();
    }

    private int getCompressLen(String s) {
        int cnt = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                len += 1 + String.valueOf(cnt).length();
                cnt = 0;
            }
        }
        return len;
    }

    /**
     * Q1.7
     * rotate layer by layer: i from 0 ... N/2
     * in each layer, left boundary to right: j from 0 + i ... N - 1 - i
     * since N * N, it is a square, each [i][j] has four related points to move together
     * @param input
     * @return
     */
    public int[][] rotateMatrix(int[][] input) {
        int N = input.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                int temp = input[i][j];
                input[i][j] = input[N - 1 - j][i];
                input[N - 1 - j][i] = input[N - 1 - i][N - 1 - j];
                input[N - 1 - i][N - 1 - j] = input[j][N - 1 - i];
                input[j][N - 1 - i] = temp;
            }
        }
        return input;
    }

    /**
     * Q1.8
     * like game of life, change in place
     * num * 10 + 1 / 0
     * @param input
     * @return
     */
    public int[][] zeroMatrix(int[][] input) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (Integer r : row) {
            for (int c = 0; c < input[0].length; c++) {
                input[r][c] = 0;
            }
        }

        for (Integer c : column) {
            for (int r = 0; r < input.length; r++) {
                input[r][c] = 0;
            }
        }
        return input;
    }

    /**
     * Q1.9
     * @param s1
     * @param s2
     * @return
     */
    public boolean isStringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        s2 += s2;
        return s2.contains(s1);
    }
}
