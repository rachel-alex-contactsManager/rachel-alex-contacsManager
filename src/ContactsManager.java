import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ContactsManager {

    private static String name;
    private static long phone;

    public ContactsManager(String name, long phone){
        this.name = name;
        this.phone =  phone;
    }

//    Setters
    public void setName (String name) {this.name =name; }
    public void setPhone (long phone) {this.phone = phone; }

//    Getters
    public String getName () { return this.name; }
    public long getPhone () { return this.phone; }

    public static void main (String [] args) {

        ContactsManager contact1 = new ContactsManager("alex", 8303232);
        ContactsManager contact2 = new ContactsManager("david", 8304343);
        contactsFile(); // created contacts file
        readWriteContacts(); // read and writes to the file
        printContact();

    } // main method

    private static void printContact () {
        System.out.printf("here is a contact: \n");
        System.out.printf("name: %s" + " | " +"phone number: %d", ContactsManager.name, ContactsManager.phone);

    }

    static void contactsFile() {
        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        System.out.println(dataDirectory.toAbsolutePath());
        Path dataFile = Paths.get(directory,filename);

        try {
            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
                System.out.println("Created directory");
            }
            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
                System.out.println("Created file");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } // try-catch block end

    } // create contacts file method

    static void readWriteContacts() {

        List<String> people = new ArrayList<>();
        try {
            Path contactsFile = Paths.get("data", "contacts.txt");
            people = Files.readAllLines(contactsFile);
            for (String line : people) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } // try-catch block to read file

        people.add("rachel"); people.add("weeb");
        try {
            Path contactsFile = Paths.get("data", "contacts.txt");
            Files.write(contactsFile, people);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } // try-catch block to write to the file

    } // end readWrite contacts method

    public static void printMenu() {
        System.out.println("User Contacts");
        System.out.println("\nHere is a list of contacts: \n");
        int i =1;
        System.out.print(" | ");
    }

} // public class end
