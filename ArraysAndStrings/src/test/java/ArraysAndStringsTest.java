import org.junit.Assert;
import org.junit.Test;

public class ArraysAndStringsTest {
    private ArraysAndStrings arraysAndStrings;

    public ArraysAndStringsTest() {
        arraysAndStrings = new ArraysAndStrings();
    }

    @Test
    public void testIsUnique() throws Exception {
        Assert.assertTrue(arraysAndStrings.isUnique(""));
        Assert.assertTrue(arraysAndStrings.isUnique("abc"));
        Assert.assertFalse(arraysAndStrings.isUnique("abb"));
    }

    @Test
    public void testCheckPermutation() throws Exception {
        Assert.assertTrue(arraysAndStrings.checkPermutation("abc", "cba"));
        Assert.assertFalse(arraysAndStrings.checkPermutation("abc", "def"));
    }

    @Test
    public void testURLify() throws Exception {
        char[] stdInput = ArrayUtil.getBufferCharArray("Mr John Smith", 200);
        char[] stdInputRes = arraysAndStrings.URLify(stdInput, 13);
        Assert.assertArrayEquals(stdInputRes, ArrayUtil.getBufferCharArray("Mr%20John%20Smith", 200));
    }

    @Test
    public void testIsPalindromePermutation() throws Exception {
        Assert.assertTrue(arraysAndStrings.isPalindromePermutation("Tact Coa"));
    }

    @Test
    public void testOneWay() throws Exception {
        Assert.assertTrue(arraysAndStrings.oneWay("pale", "ple"));
        Assert.assertTrue(arraysAndStrings.oneWay("pales", "pale"));
        Assert.assertTrue(arraysAndStrings.oneWay("pale", "bale"));
        Assert.assertFalse(arraysAndStrings.oneWay("pale", "bake"));
    }

    @Test
    public void testStringCompression() throws Exception {
        Assert.assertEquals("a2b1c5a3b1", arraysAndStrings.stringCompression("aabcccccaaab"));
        Assert.assertEquals("abc", arraysAndStrings.stringCompression("abc"));
        Assert.assertEquals("aabbcc", arraysAndStrings.stringCompression("aabbcc"));
    }

    @Test
    public void testRotateMatrix() throws Exception {
        int[][] stdinput1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] stdout1 = new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        Assert.assertArrayEquals(stdout1, arraysAndStrings.rotateMatrix(stdinput1));
    }

    @Test
    public void testZeroMatrix() throws Exception {
        int[][] stdinput1 = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] stdout1 = new int[][]{{1, 0, 3, 0}, {0, 0, 0, 0}, {9, 0, 11, 0}, {0, 0, 0, 0}};
        Assert.assertArrayEquals(stdout1, arraysAndStrings.zeroMatrix(stdinput1));
    }

    @Test
    public void testStringRotation() throws Exception {
        Assert.assertTrue(arraysAndStrings.isStringRotation("erbottlewat", "waterbottle"));
    }
}
