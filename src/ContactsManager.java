import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactsManager {

    private String name;
    private double phone;

    public ContactsManager(String name, double phone){
        this.name = name;
        this.phone =  phone;
    }

//    Setters
    public void setName (String name) {this.name =name; }
    public void setPhone (double phone) {this.phone = phone; }

//    Getters
    public String getName () { return this.name; }
    public double getPhone () { return this.phone; }


    public static void main (String [] args) {

        contactsFile(); // created contacts file
        readWriteContacts(); // read and writes to the file

    } // main method

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
