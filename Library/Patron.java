public abstract class Patron {
    
    private String name;                 
    private String address;              
    private String phoneNumber;          
    private LibraryItem[] borrowedItems; // Array to keep track of borrowed items
    private int borrowedCount;           

    // Constructor for a Patron's details
    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new LibraryItem[5]; // Initial capacity for borrowed items
        this.borrowedCount = 0;                  
    }

    // Getter to access private attributes
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

    // Method to borrow a library item
    public void borrowItem(LibraryItem item) {
        
        if (borrowedCount >= borrowedItems.length) {
            resizeArray(); 
        }
        
        // Borrow item only if copies are available
        if (item.getAmount() > 0) {
            borrowedItems[borrowedCount] = item; 
            borrowedCount++;                     // Increase count of borrowed items
            item.setAmount(item.getAmount() - 1); // Reduce item stock by 1
            System.out.println(name + " borrowed: " + item.getTitle());
        } else {
            System.out.println("No copies available for borrowing.");
        }
    }

    // Method to return a borrowed library item
    public void returnItem(LibraryItem item) {
        
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

    // method to expand the borrowedItems array
    private void resizeArray() {
        LibraryItem[] newItems = new LibraryItem[borrowedItems.length * 2];
        System.arraycopy(borrowedItems, 0, newItems, 0, borrowedItems.length);
        borrowedItems = newItems;
    }

    // Abstract method to display patron details
    public abstract void displayPatronDetails();
}
