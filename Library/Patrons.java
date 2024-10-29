public class Patrons {

    private PatronItems[] patrons;  // Array to store patrons
    private int patronCount;        // Count of patrons

    public Patrons() {
        this.patrons = new PatronItems[10];  // Start with a capacity of 10 patrons
        this.patronCount = 0;
    }

    // Method to add a patron (student or employee)
    public void addPatron(PatronItems patron) {
        if (patronCount >= patrons.length) {
            resizePatronArray();
        }
        patrons[patronCount] = patron;
        patronCount++;
        System.out.println("Patron added: " + patron.getName());
    }

    // Method to remove a patron by ID
    public void removePatron(String id) {
        int index = findPatronById(id);
        if (index >= 0) {
            patrons[index] = patrons[patronCount - 1];  // Move the last patron to this spot
            patrons[patronCount - 1] = null;
            patronCount--;
            System.out.println("Patron removed successfully.");
        } else {
            System.out.println("Patron not found.");
        }
    }

     //hardcoded edit method for Adam (Patron)
    public void editExistingPatron() {
        for (int i = 0; i < patronCount; i++) {
            if (patrons[i] instanceof Employee && ((Employee) patrons[i]).getName().equals("Adam")) {
                patrons[i].setName("AdamTheGreat");  // Updated name "AdamTheGreat"
                patrons[i].setAddress("789 Maple Ave");
                patrons[i].setPhoneNumber("555-9876");
                System.out.println("Patron 'Adam' updated to new details.");
                return;
            }
        }
        System.out.println("Patron 'Adam' not found.");
    }


    // Helper method to find a patron by ID
    public int findPatronById(String id) {
        for (int i = 0; i < patronCount; i++) {
            if (patrons[i] instanceof Student && ((Student) patrons[i]).getStudentId().equals(id)) {
                return i;  
            } else if (patrons[i] instanceof Employee && ((Employee) patrons[i]).getEmployeeId().equals(id)) {
                return i;  
            }
        }
        return -1;  // Return -1 if not found
}
    // Method to display all patrons
    public void displayAllPatrons() {
        for (int i = 0; i < patronCount; i++) {
            patrons[i].displayPatronDetails();
        }
    }

    private void resizePatronArray() {
        PatronItems[] newPatrons = new PatronItems[patrons.length * 2];
        System.arraycopy(patrons, 0, newPatrons, 0, patrons.length);
        patrons = newPatrons;
    }
}