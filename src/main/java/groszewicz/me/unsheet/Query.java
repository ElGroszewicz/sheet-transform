package groszewicz.me.unsheet;

import java.util.Scanner;

public class Query {
    private static final Scanner scanner = new Scanner(System.in);
    
    private Query() { }
    
    public static String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
    
    public static String choose(String question, String[] options) {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.print(i + ": " + options[i] + " ");
        }
        
        int choice = -1;
        while (choice < 0 || choice > options.length) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }
        }
        
        return options[choice];
    }
}
