// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/description/

public class Solution extends Reader4 {
    private char[] prevBuffer = new char[4];
    private int prevIndex = 0;
    private int prevSize = 0;

    public int read(char[] buf, int n) {
        int currentIndex = 0;

        // ensure we don't read more than n
        // In such event, we want to first continue reading from there
        // In the first call we'll directly go to else clause as both prevIndex and prevSize will be 0
        while (currentIndex < n) {
            if (prevIndex < prevSize) {
                buf[currentIndex] = prevBuffer[prevIndex];
                currentIndex++;
                prevIndex++;
            } else {
                // We are done reading from prevBuffer, so we can fetch new data
                // Since it's new data we need to reset the prevIndex
                prevIndex = 0;
                prevSize = read4(prevBuffer);
            }

            // If we got nothing back on calling read4, we are at the eof, hence done!
            if (prevSize == 0) {
                break;
            }
        }

        return currentIndex;
    }
}
