import java.util.HashMap;
import java.util.Map;

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

    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<Character, Integer>();
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



//    public boolean oneWay(String s1, String s2) {
//
//    }
}
