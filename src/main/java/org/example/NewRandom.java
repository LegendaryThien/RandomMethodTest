package org.example;

import java.util.Random;

public class NewRandom extends Random {

    public int nextInt(int low, int high) {
        if (low < high) {
            return super.nextInt(high - low + 1) + low;
        } else if (low > high) {
            return super.nextInt(low - high + 1) + high;
        } else {
            return high; // low == high
        }
    }

    public char nextChar() {
        return (char) (super.nextInt(26) + 'a');
    }

    public char nextChar(char from, char to) {
        if (from > to) { // adds 26 if it goes from c to x
            char result = (char) nextInt(from, to + 26);
            return (result > 'z') ? (char) (result - 26) : result;
        } else if (from < to) { // adds 26 if it goes from x to c
            return (char) (super.nextInt(to - from + 1) + from);
        } else {
            return from; // from == to
        }
    }

    public char nextChar(char from, int range) {
        char result = (char) nextInt(from, from + range);
        if (result > 'z') { // subtracts 26 if exceeds z
            result = (char) (result - 26);
        } else if (result < 'a') { // adds 26 if goes behind a
            result = (char) (result + 26);
        }
        return result;
    }

    public char nextSpecialChar() {
        char[] specialChars = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')'};
        return specialChars[super.nextInt(specialChars.length)];
    }
}
