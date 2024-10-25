public class Book extends LibraryItem {

    private String type; // Type of item (Audio, Printed, Electronic)

    // Constructor
    public Book(String id, String title, String author, String publisher, String isbn, int amount, String type) {
        super(id, title, author, publisher, isbn, amount);
        this.type = type;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Abstract method
    @Override
    public void displayItemDetails() {
        System.out.println("Book ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Amount in stock: " + getAmount());
        System.out.println("Type: " + getType());
    }
}