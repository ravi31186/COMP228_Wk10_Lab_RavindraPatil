package application;

public class EmploymentModel {
    public String fullName, address, contact, email, education;
    public String gender, dateAvailable, position, salary;
    public String authorized, relative, relativeDetails;

    public EmploymentModel(String fullName, String address, String contact, String email, String education,
                           String gender, String dateAvailable, String position, String salary,
                           String authorized, String relative, String relativeDetails) {

        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.education = education;
        this.gender = gender;
        this.dateAvailable = dateAvailable;
        this.position = position;
        this.salary = salary;
        this.authorized = authorized;
        this.relative = relative;
        this.relativeDetails = relativeDetails;
    }
}
