**Java Library Management System**

This Java Library Management System, created by Michael O'Brien and Adam Sparkes, manages library items (like books and magazines) and the patrons who borrow them. It includes features to:

- Add, edit, and delete library items.
- Add, edit, and delete authors and patrons.
- Borrow and return items.

**Folder Structure**

All files are in the "Library" folder:

- `Library.java`: Manages all items, authors, and patrons in the library.
- `LibraryItem.java`: General class for any library item, like books or magazines.
- `Book.java`: Class specifically for books.
- `Periodical.java`: Class specifically for periodicals (like magazines).
- `Author.java`: Stores author info, like name, birthdate, and list of works.
- `Patron.java`: General class for all patrons who borrow items.
- `Student.java`: Patron type for students, extends `Patron`.
- `Employee.java`: Patron type for employees, extends `Patron`.
- `Patrons.java`: Manages adding, editing, and removing patrons.
- `Demo.java`: Runs the app, shows the menu, and lets you pick actions.

**How to Start the App**

1. **Navigate to the Folder**

   ```bash
   cd Java-Midterm-Sprint
   cd Library
Compile All Files

bash
Copy code
javac *.java
Run the Program

bash
Copy code
java Demo


:) 