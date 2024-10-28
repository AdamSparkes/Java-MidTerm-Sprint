public class Authors {

    private Author[] authors;  // Array to store authors
    private int authorCount;   // Count of authors

    // Constructor to initialize the author array
    public Authors() {
        this.authors = new Author[10];  // Initial capacity of 10 authors
        this.authorCount = 0;
    }

    // Method to add an author
    public void addAuthor(Author author) {
        if (authorCount >= authors.length) {
            resizeArray();  // Resize array if full
        }
        authors[authorCount] = author;
        authorCount++;
        System.out.println("Author added: " + author.getName());
    }

    // Method to remove an author by name
    public void removeAuthor(String name) {
        int index = findAuthorByName(name);
        if (index >= 0) {
            authors[index] = authors[authorCount - 1];  
            authors[authorCount - 1] = null;           
            authorCount--;
            System.out.println("Author removed: " + name);
        } else {
            System.out.println("Author not found.");
        }
    }

    // Method to edit an existing author's information
    public void editAuthor(String name, Author updatedAuthor) {
        int index = findAuthorByName(name);
        if (index >= 0) {
            authors[index] = updatedAuthor;
            System.out.println("Author updated: " + updatedAuthor.getName());
        } else {
            System.out.println("Author not found.");
        }
    }

    // Helper method to find an author by name
    private int findAuthorByName(String name) {
        for (int i = 0; i < authorCount; i++) {
            if (authors[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;  // Return -1 if author not found
    }

    // Method to display all authors
    public void displayAllAuthors() {
        if (authorCount == 0) {
            System.out.println("No authors in the system.");
            return;
        }
        for (int i = 0; i < authorCount; i++) {
            authors[i].displayAuthorDetails();  // Display each author's details
        }
    }

    // Method to resize the author array when it's full
    private void resizeArray() {
        Author[] newAuthors = new Author[authors.length * 2];  // Double the array size
        System.arraycopy(authors, 0, newAuthors, 0, authors.length);
        authors = newAuthors;
    }
}