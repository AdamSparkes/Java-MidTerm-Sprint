public class Library {
    private LibraryItem[] items;
    private int itemCount;

    public Library(){
        this.items = new LibraryItem[20];
        this.itemCount = 0;
    }

    public int getItemCount() {
        return itemCount;
    }

    public LibraryItem searchItemById(String id) {
    for (int i = 0; i < itemCount; i++) {  // Assuming itemCount tracks the number of items in the library
        if (items[i].getId().equalsIgnoreCase(id)) {
            return items[i];  // Return the found item
        }
    }
    return null;  // Return null if no item is found with the given ID
}   
    // Method to add items to the Library, and resize using a seperate method if the array is full.
    public void addItem(LibraryItem item) {
        if (itemCount >= items.length) {
            resizeArray();  
        }
        items[itemCount] = item;
        itemCount++;
        System.out.println("Item added: " + item.getTitle());
    }
        //Array resizing method I copied from the initial build of my Author class.
        private void resizeArray() {
        LibraryItem[] newItems = new LibraryItem[items.length * 2];  
        System.arraycopy(items, 0, newItems, 0, items.length);  
        items = newItems;
    }
    
    //A method to search the array by id using a loop then returns the array index of that object.
    private int indexById(String id) {
    for (int i = 0; i < itemCount; i++) {
        if (items[i].getId().equals(id)) {
            return i; //returns index
        }
    }
    return -1; //returns a -1 if item id is not found, allowing me to return "item not found" in later methods.
    }

    //the method to edit an object within the array by searching it by id then replacing the existing object in the array with the update version.
   public void editItem(String id, LibraryItem updatedItem) {
    int index = indexById(id);
    if (index >= 0) {
        items[index] = updatedItem;
        System.out.println("Item updated: " + updatedItem.getTitle());
    } else {
        itemNotFoundMessage(id);  
    }
}

    //A method to delete an object using the same logic as editItem.
     public void deleteItem(String id) {
        int index = indexById(id);
        if (index >= 0) {
            // Shift the items in the array to fill the gap
            for (int i = index; i < itemCount - 1; i++) {
                items[i] = items[i + 1];
            }
            items[itemCount - 1] = null;  // Set the last element to null
            itemCount--;
            System.out.println("Item deleted.");
        } else {
            itemNotFoundMessage(id);
        }
    }

    public LibraryItem searchItemByTitle(String title) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found item:");
                items[i].displayItemDetails();
                return items[i];  // Return the found item
        }
    }
        System.out.println("Item not found.");
        return null;  // Return null if no match is found
    }

     public LibraryItem searchItemByISBN(String isbn) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getIsbn().equalsIgnoreCase(isbn)) {
                System.out.println("Found item:");
                items[i].displayItemDetails();
                return items[i];  // Return the found item
        }
    }
        System.out.println("Item not found.");
        return null; 
    }
    
    // Search for an item by author
    public LibraryItem[] searchItemByAuthor(String author) {
        LibraryItem[] results = new LibraryItem[itemCount]; // temporary array to store search results, as one author can write many items. Array size of total item count in the case of all book being written by the same author.
        int resultCount = 0;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getAuthor().equalsIgnoreCase(author)) {
                results[resultCount] = items[i];
                resultCount++;
            }
        }
        //resizing the array to the result count instead of item count to avoid returning "null" in all availible array indexs
        LibraryItem[] totalResults = new LibraryItem[resultCount];
        System.arraycopy(results, 0, totalResults, 0, resultCount);
        return totalResults;
    }
    
    private void itemNotFoundMessage(String id) {
    System.out.println("Item with ID " + id + " not found.");
    }

    //Method to borrow an item, lowering the amount in stock by 1,
    public void borrowItem(String id) {
    int index = indexById(id);
    if (index >= 0) {
        LibraryItem item = items[index];
        if (item.getAmount() > 0) {
            item.setAmount(item.getAmount() - 1);
            System.out.println("Item borrowed: " + item.getTitle());
        } else {
            System.out.println("No copies available for borrowing.");
        }
    } else {
        itemNotFoundMessage(id);
    }
    }

    //method to return an item, increasing the amount in stock by 1.
    public void returnItem(String id) {
    int index = indexById(id);
    if (index >= 0) {
        LibraryItem item = items[index];
        item.setAmount(item.getAmount() + 1);
        System.out.println("Item returned: " + item.getTitle());
    } else {
        itemNotFoundMessage(id);
    }
    }

    //method to display everything stored in the LibraryItems by looping through up to itemCount and printing their details seperated by line.
    public void displayAllItems() {
    if (itemCount == 0) {
        System.out.println("No items in the library.");
        return;
    }
    
    for (int i = 0; i < itemCount; i++) {
        items[i].displayItemDetails();
        System.out.println();  // To separate item details
    }
}








}