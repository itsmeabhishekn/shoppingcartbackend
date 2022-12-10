import java.util.Scanner;
import java.util.ArrayList;

public class BillSystem {

    public static void main(String[] args) {

        ArrayList <hotel> h1;

        boolean flag = true;
        while (flag) {
            System.out.println("***MENU***\n" +
                    "Enter Option:\n" +
                    "1.Order Menu \n" +
                    "2.Generate Bill \n" +
                    "3.View All Transactions \n" +
                    "4. \n" +
                    "0.Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("***ORDER MENU***\n" +
                            "Enter Option:\n" +
                            "1.Tea \n" +
                            "2.Coffee \n" +
                            "3.Snacks \n" +
                            "0.Exit");
                    int optionTwo = sc.nextInt();
                    int totalPrice = 0;
                    boolean flagTwo = true;
                    while (flagTwo){
                        switch (optionTwo){
                            case 1:
                                System.out.println("Enter quantity for Tea:");
                                int teaQuantity = sc.nextInt();
                                totalPrice += 10*teaQuantity;
                            case 2:
                                System.out.println("Enter quantity for Coffee:");
                                int coffeeQuantity = sc.nextInt();
                                totalPrice += 15*coffeeQuantity;
                            case 3:
                                System.out.println("Enter quantity for Snacks:");
                                int snacksQuantity = sc.nextInt();
                                totalPrice += 25*snacksQuantity;
                            case 0:
                                System.out.println("Total price ="+totalPrice);
                                flagTwo = false;

                        }
                    }

                case 2:
                case 3:
                case 4:
                case 0:
            }
        }
    }
}

