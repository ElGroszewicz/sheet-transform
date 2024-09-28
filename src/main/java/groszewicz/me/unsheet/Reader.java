package groszewicz.me.unsheet;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private Reader() { }
    
    public static List<List<String>> read(String fileName) {
        List<List<String>> data = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                data.add(Arrays.asList(values));
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public static String[][] toArray(List<List<String>> data) {
        int rows = data.size();
        int cols = rows > 0 ? data.get(0).size() : 0;
        
        String[][] parsedData = new String[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                parsedData[i][j] = data.get(i).get(j);
            }
        }
        
        return parsedData;
    }
}
