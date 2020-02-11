public class Contact {

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

//    public static void contactString(String firstName, String lastName, long phone) {
//        return firstName+" "+lastName+" | "+phone;
//    }
}
