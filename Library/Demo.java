import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Library library = new Library();  // Manages library items
        Patrons patrons = new Patrons();  // Manages patrons (students and employees)

        // Create some sample data for library and patrons
        Book book1 = new Book("B1", "Harry Potter", "J.K. Rowling", "Bloomsbury", "9780747532699", 3, "Printed");
        Periodical periodical1 = new Periodical("P1", "Vogue", "Various Authors", "Condé Nast", "1234567890", 5, "Printed");
        library.addItem(book1);
        library.addItem(periodical1);

        Student student = new Student("Mike", "123 Elm St", "555-1234", "S12345");
        Employee employee = new Employee("Adam", "456 Oak St", "555-5678", "E98765");
        patrons.addPatron(student);
        patrons.addPatron(employee);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                // Display the menu options
                System.out.println("\nLibrary Management Menu:");
                System.out.println("1. Display Library Items");
                System.out.println("2. Add Library Item");
                System.out.println("3. Remove Library Item");
                System.out.println("4. Add Patron");
                System.out.println("5. Remove Patron");
                System.out.println("6. Display All Patrons");
                System.out.println("7. Borrow Item");
                System.out.println("8. Return Item");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.println("Library Inventory:");
                        library.displayAllItems();
                    }
                    case 2 -> {
                        // Add a new library item (either Book or Periodical)
                        System.out.print("Is it a Book (1) or Periodical (2)? ");
                        int itemType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Publisher: ");
                        String publisher = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Number of Copies (Amount): ");
                        int amount = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    switch (itemType) {
                        case 1 ->                             {
                                System.out.print("Enter Format (Printed, Electronic, Audio): ");
                                String format = scanner.nextLine();
                                Book newBook = new Book("B" + (library.getItemCount() + 1), title, author, publisher, isbn, amount, format);
                                library.addItem(newBook);
                            }
                        case 2 ->                             {
                                System.out.print("Enter Format (Printed, Electronic): ");
                                String format = scanner.nextLine();
                                Periodical newPeriodical = new Periodical("P" + (library.getItemCount() + 1), title, author, publisher, isbn, amount, format);
                                library.addItem(newPeriodical);
                            }
                        default -> System.out.println("Invalid item type.");
                    }
                    }
                    case 3 -> {
                        System.out.print("Enter Item ID to Remove: ");
                        String itemId = scanner.nextLine();
                        library.deleteItem(itemId);
                    }
                    case 4 -> {
                        // Add a new patron (either Student or Employee)
                        System.out.print("Is it a Student (1) or Employee (2)? ");
                        int patronType = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();

                    switch (patronType) {
                        case 1 -> {
                            Student newStudent = new Student(name, address, phoneNumber, id);
                            patrons.addPatron(newStudent);
                        }
                        case 2 -> {
                            Employee newEmployee = new Employee(name, address, phoneNumber, id);
                            patrons.addPatron(newEmployee);
                        }
                        default -> System.out.println("Invalid patron type.");
                    }
                    }
                    case 5 -> {
                        System.out.print("Enter Patron ID to Remove: ");
                        String patronId = scanner.nextLine();
                        patrons.removePatron(patronId);
                    }
                    case 6 -> {
                        System.out.println("All Patrons:");
                        patrons.displayAllPatrons();
                    }
                    case 7 -> {
                        // Borrow an item
                        System.out.print("Enter Item ID to Borrow: ");
                        String itemId = scanner.nextLine();
                        System.out.print("Enter Patron ID: ");
                        String patronId = scanner.nextLine();

                        LibraryItem itemToBorrow = library.searchItemByISBN(itemId);
                        PatronItems patron = patrons.findPatronById(patronId);  

                        if (itemToBorrow != null && itemToBorrow.getAmount() > 0 && patron != null) {
                            patron.addItem(itemToBorrow);
                        } else {
                            System.out.println("Item not found or no copies available.");
                        }
                    }
                    case 8 -> {
                        // Return an item
                        System.out.print("Enter Item ID to Return: ");
                        String itemId = scanner.nextLine();
                        System.out.print("Enter Patron ID: ");
                        String patronId = scanner.nextLine();

                        LibraryItem itemToReturn = library.searchItemByISBN(itemId);
                        PatronItems patron = patrons.findPatronById(patronId);  

                        if (itemToReturn != null && patron != null) {
                            patron.removeItem(itemToReturn);
                        } else {
                            System.out.println("Item or Patron not found.");
                        }
                    }
                    case 9 -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
