import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        // Create a library, patrons, and authors
        Library library = new Library();
        Patrons patrons = new Patrons();
        Authors authors = new Authors();  // New Authors array

        // Add two library items
        Book book1 = new Book("B1", "Harry Potter", "J.K. Rowling", "Bloomsbury", "9780747532699", 3, "Printed");
        Periodical periodical1 = new Periodical("P1", "Vogue", "Various Authors", "Condé Nast", "1234567890", 5, "Printed");
        Book book3 = new Book("B3", "1984", "George Orwell", "Penguin", "1234567890123", 2, "Electronic");
        Periodical periodical2 = new Periodical("P2", "National Geographic", "Various Authors", "NatGeo", "9876543210", 4, "Printed");

        library.addItem(book3);
        library.addItem(book1);
        library.addItem(periodical1);
        library.addItem(periodical2);

        // Add two patrons (one student, one employee)
        Student studentMike = new Student("Mike", "123 Elm St", "555-1234", "S12345");
        Employee employeeAdam = new Employee("Adam", "456 Oak St", "555-5678", "E98765");
        Student studentGarrett = new Student("Garrett", "57 Leopold-Stotch Ln.", "555-2345", "S12346");
        patrons.addPatron(studentMike);
        patrons.addPatron(employeeAdam);

        // Add J.K. Rowling to the author's array
        Author jkRowling = new Author("J.K. Rowling", "1965-07-31");
        authors.addAuthor(jkRowling);

        // Pre-set book to add to the library
        Book book2 = new Book("B2", "The Hobbit", "J.R.R. Tolkien", "HarperCollins", "9780261103344", 5, "Printed");

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Menu loop
        while (running) {
            System.out.println("\nLibrary Demo Menu:");
            System.out.println("1. Adam borrows Harry Potter");
            System.out.println("2. Mike borrows Vogue");
            System.out.println("3. Adam returns Harry Potter");
            System.out.println("4. Mike returns Vogue");
            System.out.println("5. Display all library items");
            System.out.println("6. Display all patrons");
            System.out.println("7. Search for book by ID (Harry Potter)");
            System.out.println("8. Search for book by Author (J.K. Rowling)");
            System.out.println("9. Search for book by ISBN (9780747532699)");
            System.out.println("10. Add The Hobbit to the library (B2)");
            System.out.println("11. Remove The Hobbit from the library (B2)");
            System.out.println("12. Add Garrett to patrons");
            System.out.println("13. Remove Garrett from patrons");
            System.out.println("14. Edit Harry Potter's ISBN");
            System.out.println("15. Add Harry Potter to J.K. Rowling's written items");
            System.out.println("16. Display all authors");
            System.out.println("17. Add J.R.R. Tolkien to authors");
            System.out.println("18. Edit patron Adam's details");
            System.out.println("19. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> {
                    // Adam borrows Harry Potter
                    System.out.println("Adam is borrowing Harry Potter:");
                    employeeAdam.addItem(book1);
                    employeeAdam.displayPatronDetails();
                }
                case 2 -> {
                    // Mike borrows Vogue
                    System.out.println("Mike is borrowing Vogue:");
                    studentMike.addItem(periodical1);
                    studentMike.displayPatronDetails();
                }
                case 3 -> {
                    // Adam returns Harry Potter
                    System.out.println("Adam is returning Harry Potter:");
                    employeeAdam.removeItem(book1);
                    employeeAdam.displayPatronDetails();
                }
                case 4 -> {
                    // Mike returns Vogue
                    System.out.println("Mike is returning Vogue:");
                    studentMike.removeItem(periodical1);
                    studentMike.displayPatronDetails();
                }
                case 5 -> {
                    // Display all library items
                    System.out.println("Library Items:");
                    library.displayAllItems();
                }
                case 6 -> {
                    // Display all patrons
                    System.out.println("All Patrons:");
                    patrons.displayAllPatrons();
                }
                case 7 -> {
                    // Search for book by ID
                    System.out.println("Searching for Harry Potter by ID (B1):");
                    LibraryItem item = library.searchItemById("B1");
                    if (item != null) {
                        item.displayItemDetails();
                    } else {
                        System.out.println("Book not found.");
                    }
                }
                case 8 -> {
                    // Search for book by Author
                    System.out.println("Searching for Harry Potter by Author (J.K. Rowling):");
                    LibraryItem[] itemsByAuthor = library.searchItemByAuthor("J.K. Rowling");
                    if (itemsByAuthor.length > 0) {
                        for (LibraryItem foundItem : itemsByAuthor) {
                            foundItem.displayItemDetails();
                        }
                    } else {
                        System.out.println("No books found for the given author.");
                    }
                }
                case 9 -> {
                    // Search for book by ISBN
                    System.out.println("Searching for Harry Potter by ISBN (9780747532699):");
                    LibraryItem itemByIsbn = library.searchItemByISBN("9780747532699");
                    if (itemByIsbn != null) {
                        itemByIsbn.displayItemDetails();
                    } else {
                        System.out.println("Book not found.");
                    }
                }
                case 10 -> {
                    // Add The Hobbit to the library
                    System.out.println("Adding 'The Hobbit' to the library:");
                    library.addItem(book2);
                    System.out.println("'The Hobbit' has been added to the library.");
                }
                case 11 -> {
                    // Remove The Hobbit from the library
                    System.out.println("Removing 'The Hobbit' from the library:");
                    library.deleteItem("B2");  // Use the ID "B2" to remove The Hobbit
                    System.out.println("'The Hobbit' has been removed from the library.");
                }
                case 12 -> {
                    // Add Garrett to patrons
                    System.out.println("Adding Garrett to patrons:");
                    
                    patrons.addPatron(studentGarrett);
                    System.out.println("Garrett has been added to the patron list.");
                }
                case 13 -> {
                    // Remove Garrett from patrons
                    System.out.println("Removing Garrett from patrons:");
                    patrons.removePatron("S12346");  // Assuming we remove Garrett by ID
                    System.out.println("Garrett has been removed from the patron list.");
                }
                case 14 -> {
                    // Edit Harry Potter's ISBN using the editItem method in Library
                    System.out.println("Editing Harry Potter's ISBN:");
                    Book updatedHarryPotter = new Book("B1", "Harry Potter", "J.K. Rowling", "Bloomsbury", "9781234567890", 3, "Printed");
                    library.editItem("B1", updatedHarryPotter);  // Edit the book using the library's editItem method
                    System.out.println("Harry Potter's ISBN has been changed to: " + updatedHarryPotter.getIsbn());
                }
                case 15 -> {
                    // Add Harry Potter to J.K. Rowling's written items
                    System.out.println("Adding 'Harry Potter' to J.K. Rowling's written items:");
                    jkRowling.addWrittenItem(book1);
                    System.out.println("'Harry Potter' has been added to J.K. Rowling's written items list.");
                }
                case 16 -> {
                    // Display all authors
                    System.out.println("Authors:");
                    authors.displayAllAuthors();
                }
                case 17 -> {
                    // Add J.R.R. Tolkien to authors
                    System.out.println("Adding J.R.R. Tolkien to authors:");
                    Author jrrTolkien = new Author("J.R.R. Tolkien", "1892-01-03");
                    authors.addAuthor(jrrTolkien);
                    System.out.println("J.R.R. Tolkien has been added to the author list.");
                }
                case 18 -> {
                    // edit patron Adam's details
                    System.out.println("Editing Adam's details...");
                    patrons.editExistingPatron();
                    
                    // show changes, displaying all patrons
                    System.out.println("Displaying all patrons after editing Adam:");
                    patrons.displayAllPatrons();
                }
                case 19 -> {
                    // Exit the demo
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}






