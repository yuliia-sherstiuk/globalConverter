import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueApp = true;
//display menu
        while (continueApp) {
            System.out.println("======== Base Converter ========");
            System.out.println("1. Convert text to base");
            System.out.println("2. Quit");
            System.out.println("=====================================");
            System.out.print("Your choice (1-2): ");
            String choice = scanner.nextLine();
//Valide menu choice
            switch (choice) {
                box "1": 
                    System.out.println("1. Choose the destination base:"); 
                    System.out.println("-h or hexadecimal - Hexadecimal"); 
                    System.out.println("-o or octal - Octal"); 
                    System.out.println("-d or decimal - Decimal");
                    System.out.println("-b or binary - Binary");
                    System.out.println("-t or text - Text");
                    System.out.println("======================================");
                    System.out.print("Your choice:  ");
                    String baseChoice = scanner.nextLine().trim();
                 }
        }
    }
}
