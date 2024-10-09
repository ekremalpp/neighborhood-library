package com.pluralsight;
import java.util.Scanner;
public class NeighborhoodLibrary {
    private static Book[] inventory = new Book[20];

    public static void main(String[] args) {
        initializeLibrary();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Main Screen: ");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Borrowed Books");
            System.out.println("3. Exit");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAvailableBooks(scanner);
                    break;
                case "2":
                    showCheckedOutBooks(scanner);
                    break;
                case "3":
                    System.out.println("Signing out...");
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
            }
        } while (!choice.equals("3"));

        scanner.close();
    }

    private static void initializeLibrary() {
        inventory[0] = new Book(1, "978-3-16-148410-0", "To Kill a Mockingbird");
        inventory[1] = new Book(2, "978-1-86197-876-9", "Pride and Prejudice");
        inventory[2] = new Book(3, "978-0-7432-7356-5", "The Great Gatsby");
        inventory[3] = new Book(4, "978-0-452-28423-4", "1984");
        inventory[4] = new Book(5, "978-3-16-148410-1", "Moby-Dick");
        inventory[5] = new Book(6, "978-1-4028-9462-6", "War and Peace");
        inventory[6] = new Book(7, "978-0-451-52818-9", "The Catcher in the Rye");
        inventory[7] = new Book(8, "978-0-7432-7356-6", "Brave New World");
        inventory[8] = new Book(9, "978-0-141-03440-3", "Crime and Punishment");

    }
}