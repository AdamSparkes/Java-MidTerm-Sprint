public class Periodical extends LibraryItem {

    private String format; // "Printed" or "Electronic"

    // Constructor
    public Periodical(String id, String title, String author, String publisher, String isbn, int amount, String format) {
        super(id, title, author, publisher, isbn, amount);
        this.format = format;
    }

   
    public String getFormat() {
        return format;
    }

    
    public void setFormat(String format) {
        this.format = format;
    }

    // Implementing the abstract method to display item details
    @Override
    public void displayItemDetails() {
        System.out.println("Periodical ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Amount in stock: " + getAmount());
        System.out.println("Format: " + getFormat());
    }
}