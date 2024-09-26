package groszewicz.me.manual;

import groszewicz.me.unsheet.Parser;

public class ParserManTests {
    public static void testParsing(String[] args) {
        Parser parser = new Parser();
        parser.read("src/test/java/groszewicz/me/manual/test.csv");
        System.out.println(parser.getData().toString());
    }
}
