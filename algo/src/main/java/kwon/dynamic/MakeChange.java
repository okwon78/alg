package kwon.dynamic;

import java.util.Arrays;

/**
 * Created by nhnent on 15/01/2017.
 */
public class MakeChange {

    private int cache[][];

    private int[] coins = {25, 10, 5, 1};

    public MakeChange() {

    }

    public int makeChange(int amount){
        cache = new int[amount + 1][coins.length];

        for(int i=0; i<amount+1; i++)
            for(int j=0; j<coins.length; j++)
                cache[i][j] = -1;

        return makeChange(amount, 0);
    }

    public int makeChange(int amount, int index) {
        if (index == coins.length)
            return 0;

        int coin = coins[index];

        if(cache[amount][index] > -1)
            return cache[amount][index];

        int ways = 0;
        for(int i = 0; amount >= coin * i; i++ ) {
            int amountLeft = amount - (coin * i);

            if (amountLeft < 0)
                break;

            if (amountLeft == 0) {
                ways += 1;
                break;
            }

            ways += makeChange(amountLeft, index + 1);
        }

        cache[amount][index] = ways;

        return ways;
    }

    public int makeChange2(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n+1][denoms.length];
        return makeChange2(n, denoms, 0, map);
    }

    private int makeChange2(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0)
            return map[amount][index];

        if (index >= denoms.length - 1)
            return 1;

        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange2(amountRemaining, denoms, index + 1, map);
        }

        map[amount][index] = ways;
        return ways;
    }
}
