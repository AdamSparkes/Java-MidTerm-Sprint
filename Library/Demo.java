import java.util.Scanner;  // Import Scanner to get input from user

public class Demo {
    public static void main(String[] args) {
        
        Library library = new Library();

        // Create a book (Harry Potter) and a magazine (Vogue)
        Book book1 = new Book("B001", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Bloomsbury", "9780747532699", 3, "Printed");
        Periodical periodical1 = new Periodical("P001", "Vogue", "Various Authors", "Condé Nast", "1234567890", 5, "Printed");

        // Add the book and magazine to the library
        library.addItem(book1);
        library.addItem(periodical1);

        // Use Scanner to get user input and keep the menu running
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            // Display the menu until the user chooses to exit
            while (running) {
                System.out.println("\nLibrary Menu:");
                System.out.println("1. Display Library Inventory");
                System.out.println("2. Display Author Details");
                System.out.println("3. Display Student Details");
                System.out.println("4. Display Employee Details");
                System.out.println("5. Student borrows a book");
                System.out.println("6. Employee borrows a magazine");
                System.out.println("7. Student returns a book");
                System.out.println("8. Employee returns a magazine");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();  // Get user choice
                scanner.nextLine(); 

                // Do an action based on the user's choice
                switch (choice) {
                    case 1 -> {
                        // Show all items in the library
                        System.out.println("Library Inventory:");
                        library.displayAllItems();
                    }
                    case 2 -> {
                        // Show details of the author (J.K. Rowling)
                        Author author1 = new Author("J.K. Rowling", "1965-07-31");
                        author1.addWrittenItem(book1);  
                        System.out.println("\nAuthor Details:");
                        author1.displayAuthorDetails();
                    }
                    case 3 -> {
                        // Show details of a student (Mike)
                        Student student = new Student("Mike", "123 Elm St", "555-1234", "S12345");
                        System.out.println("\nDisplaying Student Details:");
                        student.displayPatronDetails();
                    }
                    case 4 -> {
                        // Show details of an employee (Adam)
                        Employee employee = new Employee("Adam", "456 Oak St", "555-5678", "E98765");
                        System.out.println("\nDisplaying Employee Details:");
                        employee.displayPatronDetails();
                    }
                    case 5 -> {
                        // Student (Mike) borrows the book (Harry Potter)
                        Student student = new Student("Mike", "123 Elm St", "555-1234", "S12345");
                        System.out.println("\nStudent tries to borrow 'Harry Potter and the Sorcerer's Stone':");
                        student.addItem(book1);  
                        student.displayPatronDetails();  
                    }
                    case 6 -> {
                        // Employee (Adam) borrows the magazine (Vogue)
                        Employee employee = new Employee("Adam", "456 Oak St", "555-5678", "E98765");
                        System.out.println("\nEmployee tries to borrow 'Vogue':");
                        employee.addItem(periodical1);  
                        employee.displayPatronDetails();  
                    }
                    case 7 -> {
                        // Student (Mike) returns the book
                        Student student = new Student("Mike", "123 Elm St", "555-1234", "S12345");
                        System.out.println("\nStudent returns 'Harry Potter and the Sorcerer's Stone':");
                        student.removeItem(book1);  
                        student.displayPatronDetails();  
                    }
                    case 8 -> {
                        // Employee (Adam) returns the magazine
                        Employee employee = new Employee("Adam", "456 Oak St", "555-5678", "E98765");
                        System.out.println("\nEmployee returns 'Vogue':");
                        employee.removeItem(periodical1);  
                        employee.displayPatronDetails();  
                    }
                    case 9 -> {
                        // Exit the program
                        System.out.println("Exiting...");
                        running = false;  
                    }
                    default -> System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        }
    }
}
