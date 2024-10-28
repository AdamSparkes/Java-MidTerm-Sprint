import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Library library = new Library();
        
        // Create a book and periodical
        Book book1 = new Book("B001", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Bloomsbury", "9780747532699", 3, "Printed");
        Periodical periodical1 = new Periodical("P001", "Vogue", "Various Authors", "Condé Nast", "1234567890", 5, "Printed");
        
        // Add to the library
        library.addItem(book1);
        library.addItem(periodical1);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\nLibrary Menu:");
                System.out.println("1. Display Library Inventory");
                System.out.println("2. Display Author Details");
                System.out.println("3. Add New Item");
                System.out.println("4. Edit Existing Item");
                System.out.println("5. Delete Item");
                System.out.println("6. Search Item by Title");
                System.out.println("7. Search Item by Author");
                System.out.println("8. Search Item by ISBN");
                System.out.println("9. Borrow an Item");
                System.out.println("10. Return an Item");
                System.out.println("11. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Library Inventory:");
                        library.displayAllItems();
                    }
                    case 2 -> {
                        Author author1 = new Author("J.K. Rowling", "1965-07-31");
                        author1.addWrittenItem(book1);
                        System.out.println("\nAuthor Details:");
                        author1.displayAuthorDetails();
                    }
                    case 3 -> {
                        System.out.print("Enter type (1 for Book, 2 for Periodical): ");
                        int type = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Publisher: ");
                        String publisher = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Number of Copies: ");
                        int copies = scanner.nextInt();
                        scanner.nextLine();

                        if (type == 1) {
                            System.out.print("Enter Format (Printed, Electronic, Audio): ");
                            String format = scanner.nextLine();
                            Book book = new Book("B" + (library.getItemCount() + 1), title, author, publisher, isbn, copies, format);
                            library.addItem(book);
                        } else {
                            System.out.print("Enter Format (Printed, Electronic): ");
                            String format = scanner.nextLine();
                            Periodical periodical = new Periodical("P" + (library.getItemCount() + 1), title, author, publisher, isbn, copies, format);
                            library.addItem(periodical);
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter Item ID to Edit: ");
                        String id = scanner.nextLine();
                        LibraryItem item = library.searchItemByISBN(id);

                        if (item != null) {
                            System.out.print("Enter new title: ");
                            String newTitle = scanner.nextLine();
                            item.setTitle(newTitle);
                            System.out.println("Item updated successfully.");
                        } else {
                            System.out.println("Item not found.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Enter Item ID to Delete: ");
                        String id = scanner.nextLine();
                        library.deleteItem(id);
                    }
                    case 6 -> {
                        System.out.print("Enter Title to Search: ");
                        String title = scanner.nextLine();
                        library.searchItemByTitle(title);
                    }
                    case 7 -> {
                        System.out.print("Enter Author to Search: ");
                        String author = scanner.nextLine();
                        library.searchItemByAuthor(author);
                    }
                    case 8 -> {
                        System.out.print("Enter ISBN to Search: ");
                        String isbn = scanner.nextLine();
                        library.searchItemByISBN(isbn);
                    }
                    case 9 -> {
                        System.out.print("Enter Item ID to Borrow: ");
                        String id = scanner.nextLine();
                        library.borrowItem(id);
                    }
                    case 10 -> {
                        System.out.print("Enter Item ID to Return: ");
                        String id = scanner.nextLine();
                        library.returnItem(id);
                    }
                    case 11 -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}