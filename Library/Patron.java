public abstract class Patron {

    private String name;                  
    private String address;               
    private String phoneNumber;           
    private LibraryItem[] borrowedItems;  // Array to keep track of borrowed items
    private int borrowedCount;            

    // Constructor to initialize a Patron's details
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new LibraryItem[5]; // Initial capacity for borrowed items
        this.borrowedCount = 0;
    }

    // Getters to access private attributes
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LibraryItem[] getBorrowedItems() {
        return borrowedItems;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    // Setters to update private attributes
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // add a library item to borrowed items
    public void addItem(LibraryItem item) {
        if (borrowedCount >= borrowedItems.length) {
            resizeArray();
        }
        
        // Add item only if copies are available
        if (item.getAmount() > 0) {
            borrowedItems[borrowedCount] = item;
            borrowedCount++;                     
            item.setAmount(item.getAmount() - 1); 
            System.out.println(name + " borrowed: " + item.getTitle());
        } else {
            System.out.println("No copies available for borrowing.");
        }
    }

    // remove a borrowed library item
    public void removeItem(LibraryItem item) {
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedItems[i] == item) {
                borrowedItems[i] = borrowedItems[borrowedCount - 1];
                borrowedItems[borrowedCount - 1] = null;
                borrowedCount--;
                item.setAmount(item.getAmount() + 1);
                System.out.println(name + " returned: " + item.getTitle());
                return;
            }
        }
        System.out.println("This item was not borrowed by " + name);
    }

    // Method to expand the borrowedItems array when needed
    private void resizeArray() {
        LibraryItem[] newItems = new LibraryItem[borrowedItems.length * 2];
        System.arraycopy(borrowedItems, 0, newItems, 0, borrowedItems.length);
        borrowedItems = newItems;
    }

    // Abstract method to display patron details
    public abstract void displayPatronDetails();
}
