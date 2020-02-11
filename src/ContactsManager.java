import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ContactsManager {

    private static String name;
    private static long phone;
    private static List contactList;

    public static void main (String [] args) {

        Contact contact1 = new Contact("leo", "dicaprio", 8768990);
        Contact contact2 = new Contact("matt", "damon", 2108754);
        Contact contact3 = new Contact("keanu", "reeves", 2199435);

        List<String> contactList = new ArrayList<>();
        contactList.add(contact1.toString());
        contactList.add(contact2.toString());
        contactList.add(contact3.toString());
        System.out.println(contactList); // need to find way to convert contacts to print correctly, instead of toString()

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

        List<String> contact = new ArrayList<>();
        try {
            Path contactsFile = Paths.get("data", "contacts.txt");
            contact = Files.readAllLines(contactsFile);
            for (Object Contact : contact) {
                System.out.println("----------------------------------");
                System.out.println(contact+"!");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } // try-catch block to read file

        contact.add(""); contact.add("");
        try {
            Path contactsFile = Paths.get("data", "contacts.txt");
            Files.write(contactsFile, contact);
            System.out.println("----------------------------------");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } // try-catch block to write to the file

    } // end readWrite contacts method

//    public static void printMenu() {
//        System.out.println("User Contacts");
//        System.out.println("\nHere is a list of contacts: \n");
//        int i =1;
//        System.out.print(" | ");
//    }

} // public class end
