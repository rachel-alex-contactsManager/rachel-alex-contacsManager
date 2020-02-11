import java.io.Serializable;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private long phone;

    // setters

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPhone(long phone) { this.phone = phone; }

    // getters

    public String getFirstName() {return this.firstName;}
    public String getLastName() { return this.lastName;}
    public long getPhone() { return this.phone; }

    // constructor

    Contact (String firstName, String lastName, long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // converts object to a string

    public String toString() {
       return new StringBuffer(" |First Name: ").append(this.firstName)
               .append(" Last Name: ").append(this.lastName).append(" Phone Number: ").append(this.phone).toString();
    }







}
