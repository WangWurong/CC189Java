public final class ArrayUtil {
    // prevent this class to be constructed
    private ArrayUtil() {}

    /**
     * Given the size, generate an empty char array for that
     * @param size
     * @return
     */
    public static char[] getEmptyCharArrayBySize(int size) {
        return new char[size];
    }

    /**
     * Given the original string, generate the char array with the string letter and buffer
     * @param input
     * @param size
     * @return
     */
    public static char[] getBufferCharArray(String input, int size) {
        if (input.length() > size) {
            return null;
        }
        char[] res = new char[size];
        for (int i = 0; i < input.length(); i++) {
            res[i] = input.charAt(i);
        }
        return res;
    }

}
