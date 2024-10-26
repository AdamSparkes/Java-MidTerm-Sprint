public class Student extends Patron {
    private String studentId;

    // Constructor 
    public Student(String name, String address, String phoneNumber, String studentId) {
        super(name, address, phoneNumber);
        this.studentId = studentId;
    }

    // Getter for student ID
    public String getStudentId() {
        return studentId;
    }

    // Setter for student ID
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    // Absract
    @Override
    public void displayPatronDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + studentId);
        System.out.println("Address: " + getAddress());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Borrowed Items:");
        for (int i = 0; i < getBorrowedCount(); i++) {
            System.out.println(" - " + getBorrowedItems()[i].getTitle());
        }
    }
}
