package groszewicz.me.unsheet;

import java.util.Arrays;

public class Csv {
    private final int rows;
    private final int cols;
    private final String[][] data;
    
    public Csv(int rows, int cols, String[][] data) {
        this.rows = rows;
        this.cols = cols;
        this.data = data;
    }
    
    @Override
    public String toString() {
        return Arrays.deepToString(data);
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }
    
    public String[][] getData() {
        return data;
    }
}
