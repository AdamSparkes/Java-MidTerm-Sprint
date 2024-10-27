public abstract class LibraryItem {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int amount;

     public LibraryItem(String id, String title, String author, String publisher, String isbn, int amount) {
       this.id = id;
       this.title = title;
       this.author = author;
       this.publisher = publisher;
       this.isbn = isbn;
       this.amount = amount;

    }

    //Getters
    public String getId() {
        return id;
    }

     public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

   
    public String getIsbn() {
        return isbn;
    }

    public int getAmount() {
        return amount;
    }

    //Setters
    public void setId(String id) {
        this.id = id;
    }

     public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // Abstract method for displaying item details 
    public abstract void displayItemDetails();
}

