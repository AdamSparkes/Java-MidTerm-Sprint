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

    // Helper method to find a patron by ID
   public PatronItems findPatronById(String id) {
    for (int i = 0; i < patronCount; i++) {
        if (patrons[i] instanceof Student && ((Student) patrons[i]).getStudentId().equals(id)) {
            return patrons[i];  // Return the actual PatronItems object
        } else if (patrons[i] instanceof Employee && ((Employee) patrons[i]).getEmployeeId().equals(id)) {
            return patrons[i];  // Return the actual PatronItems object
        }
    }
    return null;  // Return null if not found
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