package platform;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        System.out.println("++ NETWORK PROVIDER SYSTEM ++ \n");
        System.out.println("Please enter number for operation: \n1.new customer,delete old list \n" +
                "2.read existing customer list and print to screen \n3.quit");
        Scanner console1 = new Scanner(System.in);
        String input = console1.nextLine();
        switch (input) {
            case "1":
                Writer.main(null);
                break;
            case "2":
                Reader.main(null);
                break;
            case "3":
                break;
        }
    }
}