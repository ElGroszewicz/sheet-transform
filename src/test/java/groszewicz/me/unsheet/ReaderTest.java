package groszewicz.me.unsheet;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReaderTest {
    
    @Test
    void testReadCsv() throws IOException {
        // Create a temporary CSV file
        File tempFile = File.createTempFile("test", ".csv");
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("name,age,city\n");
            writer.write("John,30,New York\n");
            writer.write("Alice,25,Los Angeles\n");
        }
        
        List<List<String>> result = Reader.read(tempFile.getAbsolutePath());
        
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("name", "age", "city"));
        expected.add(Arrays.asList("John", "30", "New York"));
        expected.add(Arrays.asList("Alice", "25", "Los Angeles"));
        
        assertEquals(expected, result);
        
        tempFile.deleteOnExit();
    }
    
    @Test
    void testToArrayList() {
        List<List<String>> data = new ArrayList<>();
        data.add(Arrays.asList("name", "age", "city"));
        data.add(Arrays.asList("John", "30", "New York"));
        data.add(Arrays.asList("Alice", "25", "Los Angeles"));
        
        String[][] csv = Reader.toArray(data);
        
        String[][] expected = {{"name", "age", "city"}, {"John", "30",
                "New " + "York"}, {"Alice", "25", "Los Angeles"}};
        
        assertArrayEquals(expected, csv);
    }
    
    @Test
    void testToArrayEmptyCsv() {
        List<List<String>> emptyData = new ArrayList<>();
        String[][] csv = Reader.toArray(emptyData);
        
        assertArrayEquals(new String[0][0], csv);
    }
    
    
    @Test
    void testInconsistentCsv() {
        List<List<String>> data = new ArrayList<>();
        data.add(Arrays.asList("name", "age"));
        data.add(Arrays.asList("John", "30", "New York"));
        data.add(Arrays.asList("Alice", "25", "Los Angeles"));
        
        String[][] csv = Reader.toArray(data);
        
        String[][] expected =
                {{"name", "age"}, {"John", "30"}, {"Alice", "25"}};
        
        assertArrayEquals(expected, csv);
    }
}
