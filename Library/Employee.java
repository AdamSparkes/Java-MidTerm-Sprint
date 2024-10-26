public class Employee extends Patron {
    private String employeeId;

    // Constructor
    public Employee(String name, String address, String phoneNumber, String employeeId) {
        super(name, address, phoneNumber);
        this.employeeId = employeeId;
    }

    // Getter for employee ID
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter for employee ID
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Absract 
    @Override
    public void displayPatronDetails() {
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Address: " + getAddress());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Borrowed Items:");
        for (int i = 0; i < getBorrowedCount(); i++) {
            System.out.println(" - " + getBorrowedItems()[i].getTitle());
        }
    }
}
