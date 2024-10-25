public class Author {

    private String name;
    private String dateOfBirth;
    private LibraryItem[] writtenItems; 
    private int itemCount; 

    public Author (String name, String dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.writtenItems = new LibraryItem[5];
        this.itemCount = 0;
    }

    //Getters
     public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Getter for the array of written items
    public LibraryItem[] getWrittenItems() {
        return writtenItems;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //Adding items to an author's list of written items.
    public void addWrittenItem(LibraryItem item) {
        if (itemCount >= writtenItems.length) {
            resizeArray(); 
        }
        writtenItems[itemCount] = item;
        itemCount++;
    }

    // Method to resize the array when it is full
    private void resizeArray() {
        LibraryItem[] newItems = new LibraryItem[writtenItems.length * 2]; 
        System.arraycopy(writtenItems, 0, newItems, 0, writtenItems.length);
        writtenItems = newItems;
    }

    // Method to display the author's details
    public void displayAuthorDetails() {
        System.out.println("Author Name: " + getName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Written Items: ");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(" - " + writtenItems[i].getTitle());
        }
    }
}