package kwon.dynamic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by nhnent on 04/01/2017.
 */
public class Stages {

    public int getNumbyBruteForce(int n) {

        return bruteForce(n-1) + bruteForce(n-2) + bruteForce(n-3);
    }

    private int bruteForce(int n) {

        if (n < 0)
            return 0;

        if (n == 0)
            return 1;


        return bruteForce(n-1) + bruteForce(n-2) + bruteForce(n-3);
    }

    private int[] cache;

    public int getNumbyMemorization(int n) {

        cache = new int[n];
        Arrays.fill(cache, -1);
        return memorization(n-1) + memorization(n-2) + memorization(n-3);
    }

    private int memorization(int n) {

        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        if (cache[n] > -1)
            return cache[n];

        cache[n] = memorization(n-1) + memorization(n-2) + memorization(n-3);

        return cache[n];
    }
}
