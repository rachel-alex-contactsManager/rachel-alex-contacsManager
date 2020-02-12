public class Contact {

    private String firstName;
    private String lastName;
    private String phone;

    // setters

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(String phone) { this.phone = phone; }

    // getters

    public String getFirstName() {return this.firstName;}
    public String getLastName() { return this.lastName;}
    public String getPhone() { return this.phone; }

    // id method
    private static long counter = -1;
    private long id;
    public long getId() {
        return this.id;
    }

    // constructor

    Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.id = counter;
        counter++;
    }

    // converts object to a string

    public String toString() {
        return new StringBuffer(" |First Name: ").append(this.firstName)
                .append(" Last Name: ").append(this.lastName).append(" Phone Number: ").append(this.phone).toString();
    }

}
