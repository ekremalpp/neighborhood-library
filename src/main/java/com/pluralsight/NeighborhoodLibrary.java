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
        inventory[9] = new Book(10, "978-0-152-45661-3", "Jane EYRE");
        inventory[10] = new Book(11, "978-0-141-03440-3", "Gurur ve On yargi");
        inventory[11] = new Book(12, "978-0-451-52984-1", "Hayvan Çiftliği");
        inventory[12] = new Book(13, "978-1-4416-3050-4", "Kayıp Zamanın İzinde");
        inventory[13] = new Book(14, "978-0-141-03450-2", "Jane Eyre");
        inventory[14] = new Book(15, "978-0-307-26931-3", "Gurur ve Ön Yargı");
        inventory[15] = new Book(16, "978-0-7432-7356-7", "Küçük Kadınlar");
        inventory[16] = new Book(17, "978-0-06-093546-7", "Savaş ve Barış");
        inventory[17] = new Book(18, "978-0-14-044927-3", "İki Şehrin Hikayesi");
        inventory[18] = new Book(19, "978-1-5011-9781-0", "On Küçük Zenci");
        inventory[19] = new Book(20, "978-1-4516-2205-3", "Büyük Düşünme Gücü");
    }

    private static void showAvailableBooks(Scanner scanner){
        System.out.println("Available Books");
        for(Book book:inventory){
            if(!book.isCheckedOut()) {
                System.out.println("ID:" + book.getId()+",ISBN:"+ book.getIsbn()+"Heading:" + book.getTitle());
            }
        }
        String input = scanner.nextLine();



        if(!input.equalsIgnoreCase("X")) {
            int id =Integer.parseInt(input);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            for(Book book:inventory) {
                if(book.getId()==id && !book.isCheckedOut()) {
                    book.checkOut(name);
                    System.out.println(book.getTitle()+"Browwed successfully");
                    return;
                }
            }
            System.out.println("Invalid ID or book already borrowed");
        }

    }
    private static void showCheckedOutBooks(Scanner scanner) {
        System.out.println(" Broweed Books:");
        for (Book book : inventory) {
            if(book.isCheckedOut()) {
                System.out.println("ID:" + book.getId() + "ISBNE:"+book.getIsbn()+"Heading" +book.getTitle() + "Borrower"+book.getCheckedOutTo());

            }
        }
        System.out.println("Enter the ID of the book you want to return or press 'X' to exit");
        String input = scanner.nextLine();
        if(!input.equalsIgnoreCase("X")) {
            int id = Integer.parseInt(input);
            for(Book book : inventory) {
                if(book.getId()== id && book.isCheckedOut()) {
                    book.checkIn();
                    System.out.println(book.getTitle() + "successfully returned");
                    return;
                }
            }
            System.out.println("Invalid ID or book has already been returned");
        }
    }

}