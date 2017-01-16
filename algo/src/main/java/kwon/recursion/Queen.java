package kwon.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nhnent on 15/01/2017.
 */
public class Queen {

    public static final int GRID_SIZE = 8;

    List<Map<Integer, Integer>> results = new ArrayList<Map<Integer, Integer>>();

    public void run() {

        for (int col = 0; col <GRID_SIZE; col++) {

            HashMap<Integer, Integer> places = new HashMap<Integer, Integer>();
            places.put(0, col);
            placeQueens(1, places);
        }

        System.out.println(results.size());
    }

    public void placeQueens(int row, HashMap<Integer, Integer> places) {

        if (row == GRID_SIZE) {
            results.add(places);
            return;
        }

        for(int col = 0; col <GRID_SIZE; col++) {
            if (checkValidation(row, col, places)) {
                HashMap<Integer, Integer> new_stack = (HashMap<Integer, Integer>) places.clone();

                new_stack.put(row, col);
                placeQueens(row+1, new_stack);
            }
        }
    }

    public boolean checkValidation(int row, int col, HashMap<Integer, Integer> places) {

        for(Map.Entry<Integer, Integer> entry: places.entrySet()) {
            int preceding_row = entry.getKey();
            int preceding_col = entry.getValue();

            if (preceding_col == col)
                return false;

            int colDistance = Math.abs(preceding_col - col);
            int rowDistance = Math.abs(preceding_row - row);

            if (colDistance == rowDistance)
                return false;
        }

        return true;
    }
}
