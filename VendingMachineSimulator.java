import java.util.Scanner;

public class VendingMachineSimulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] items = {"Chips", "Chocolate", "Juice", "Water"};
        int[] prices = {20, 30, 40, 15};
        int[] quantity = {5, 4, 3, 6};

        System.out.println("=== VENDING MACHINE ===");

        // Display products
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]
                    + " - Rs." + prices[i]
                    + " (Available: " + quantity[i] + ")");
        }

        System.out.print("\nChoose an item number: ");
        int choice = input.nextInt();

        // Array index begins from 0, so subtract 1
        int index = choice - 1;

        if (index < 0 || index >= items.length) {
            System.out.println("Invalid item number.");
        } else if (quantity[index] == 0) {
            System.out.println("Sorry, " + items[index] + " is out of stock.");
        } else {
            System.out.println("You selected: " + items[index]);
            System.out.print("Insert money (Rs.): ");
            int money = input.nextInt();

            if (money < prices[index]) {
                System.out.println("Not enough money.");
                System.out.println("Money returned: Rs." + money);
            } else {
                quantity[index] = quantity[index] - 1;

                int change = money - prices[index];

                System.out.println("Dispensing " + items[index] + "...");
                System.out.println("Please collect your item.");

                if (change > 0) {
                    System.out.println("Your change: Rs." + change);
                }

                System.out.println("Remaining " + items[index] + ": " + quantity[index]);
            }
        }

        input.close();
    }
}   