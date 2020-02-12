import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ContactsManager {

    private static List <Contact> contactList = new ArrayList<>();
    private static List <Contact> objectList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static List <String> menuList = new ArrayList<>();
    private static List <String> crudParameters = new ArrayList<>();
    private static List <String> Continue = new ArrayList<>();

    public static void main (String [] args) {
        contactsFile(); // created contacts file
//        Menu list set up
        menuList = Arrays.asList(" View Contacts.", " Search", " Add", " Delete", " Exit.\n__" );
        crudParameters = Arrays.asList("First Name", "Last Name", "Phone\n__");
        Continue = Arrays.asList("Continue?.\n___");

        try {
            contactList = toList();
        } catch (Exception e) {
            Contact contact1 = new Contact("leo", "dicaprio", "8768990");
            Contact contact2 = new Contact("matt", "damon", "2108754");
            Contact contact3 = new Contact("keanu", "reeves", "2199435");
            contactList.add(contact1);
            contactList.add(contact2);
            contactList.add(contact3);
            readWriteContacts(); // read and writes to the file
        }
        if (contactList.size() <= 0) {
            Contact contact1 = new Contact("leo", "dicaprio", "8768990");
            Contact contact2 = new Contact("matt", "damon", "2108754");
            Contact contact3 = new Contact("keanu", "reeves", "2199435");
            contactList.add(contact1);
            contactList.add(contact2);
            contactList.add(contact3);
            readWriteContacts(); // read and writes to the file
        }
//        fileToObject();

        // menu switch case start
        int userSelect = Integer.MAX_VALUE;
        do {
            userSelect = listSelect(menuList);
            switch (userSelect) {
                case 1:
                    userSelect = 1;
                    viewList();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    add();
                    break;
//                case 4:
//                    delete();
//                    break;
                case 5:
                    System.out.println("goodbye");
                    break;
                default:
                    break;
            }
        } while (userSelect != 1);
        // menu switch case end

    }
    // main method end

    // creates contacts file and directory
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

    }
    // create contacts file method end

    // creates a list of contacts to a string for the file
    static List<String> toList() {
        List<String> contacts = null;
        try {
            Path contactsListPath = Paths.get("data", "contacts.txt");
            contacts = Files.readAllLines(contactsListPath);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return contacts;
    }
    //converting contacts to string for file


    // reads and writes to the contacts.txt file
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

//        contactList.add(contact1);
        try {
            Path contactsFile = Paths.get("data", "contacts.txt");
            Files.write(contactsFile, contact);
            System.out.println("----------------------------------");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } // try-catch block to write to the file

    }
    // end readWrite contacts method
    //might need to change readWrite method

//    public static void fileToObject() {
//        objectList.clear();
//        List<String> myList = toList();
//        String strList = String.join(" ,", myList);
//        String [] strArr = strList.split(",");
//        for (String contact : strArr) {
//            contact = contact.replace("|", "&");
//            String [] contactElements = contact.split("&");
//            String [] nameArray = contactElements[0].split(" ");
//            Contact newContact = new Contact(nameArray[0].trim(), nameArray[1].trim(), contactElements[1], contactElements[2]);
//            objectList.add(newContact);
//        }
//    }

    // select from the list method
    public static int listSelect(List<String> inputList) {
        int output = Integer.MAX_VALUE;
        boolean loop = true;
        do {
            int counter = 1;
            for (String option : inputList) {
                System.out.println(counter + option);
                counter++;
            }
            System.out.println("select an option");
            try {
                output = Integer.valueOf(scanner.next());
                if (output <= counter && output >0) {
                    loop = false;
                }
                } catch (Exception e) {
                System.out.println("invalid input");
            }

        } while (loop);
        return output;
    }

    // view contacts list
    public static void viewList() {
        boolean loop = true;
        do {
            System.out.printf("name%-15s phone%-9s\n", "","");
            for (Contact eachContact : contactList) {
                System.out.println(eachContact);
            }
            scanner.nextLine();
            try {
                int userSelect = listSelect(Continue);
                if (userSelect == 1) {
                    loop = false;
                }
            } catch (Exception ignored){}
        } while (loop);
    }

    // add contact method
    public static void add() {
        boolean loop = true;
        scanner.nextLine();
        System.out.println("enter first name: \t");
        String firstName = scanner.nextLine();
        System.out.println("enter last name: \t");
        String lastName = scanner.nextLine();
        String phone = "";
        do {
            System.out.println("input phone number (with all ten digits): ");
            try {
                long phoneNum = Long.valueOf(scanner.next());
                if (Long.toString(phoneNum).length()== 10) {
                    loop = false;
                    phone = Long.toString(phoneNum);
                }
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        } while (loop);
        Contact newContact = new Contact(firstName, lastName, phone);
        contactList.add(newContact);
        readWriteContacts();
    }

    // search switch case method
    public static void search() {
        int userSelect = listSelect(crudParameters);
        switch (userSelect) {
            case 1:
                searchFirst();
                break;
            case 2:
                searchLast();
                break;
            case 3:
                searchPhone();
                break;
            default:
                break;
        }
    }

    // search by first name
    public static Map<String, Long> searchFirst() {
        boolean loop = true;
        Map<String, Long> outMap;
        do {
            outMap = new HashMap<>();
            scanner.nextLine();
            System.out.println("\nenter search here: \n");
            String userSearch = scanner.nextLine();
            for (Contact result : objectList) {
                String firstName = result.getFirstName();
                if (firstName.toLowerCase().contains(userSearch.toLowerCase())) {
                    outMap.put(result.toString(), result.getId());
                }
            }
            if (outMap.size()==0) {
                System.out.println("\nno result :/ \n");
            } else {
                System.out.println("results: ");
            }
            for (Map.Entry<String, Long> entry : outMap.entrySet()){
                System.out.println(entry.getKey());
            }
            System.out.println("\n");
            int userSelect = listSelect(Continue);
            if (userSelect == 1) {
                loop = false;
            }
        } while (loop);
        return outMap;
    }

    // search by last name
    public static Map<String, Long> searchLast() {
        boolean loop = true;
        Map<String, Long> outMap;
        do {
            outMap = new HashMap<>();
            scanner.nextLine();
            System.out.println("\nenter search here: \n");
            String userSearch = scanner.next();
            scanner.nextLine();
            for (Contact result : objectList) {
                String lastName = result.getLastName();
                if (lastName.toLowerCase().contains(userSearch.toLowerCase())) {
                    outMap.put(result.toString(), result.getId());
                }
            }
            if (outMap.size()==0) {
                System.out.println("\nno result :/ \n");
            } else {
                System.out.println("results: ");
            }
            for (Map.Entry<String, Long> entry : outMap.entrySet()) {
                System.out.println(entry.getKey());
            }
            System.out.println("\n");
            int userSelect = listSelect(Continue);
            if (userSelect == 1) {
                loop = false;
            }
        } while (loop);
        return outMap;
    }

    public static Map<String, Long> searchPhone() {
        boolean loop = true;
        Map<String, Long> outMap;
        do {
            outMap = new HashMap<>();
            scanner.nextLine();
            System.out.println("\nenter search here: \n");
            String userSearch = scanner.next();
            scanner.nextLine();
            for (Contact result : objectList) {
                String phone = result.getLastName();
                if (phone.toLowerCase().contains(userSearch.toLowerCase())) {
                    outMap.put(result.toString(), result.getId());
                }
            }
            if (outMap.size()==0) {
                System.out.println("\nno result :/ \n");
            } else {
                System.out.println("results: ");
            }
            for (Map.Entry<String, Long> entry : outMap.entrySet()) {
                System.out.println(entry.getKey());
            }
            System.out.println("\n");
            int userSelect = listSelect(Continue);
            if (userSelect == 1) {
                loop = false;
            }
        } while (loop);
        return outMap;
    }

} // public class end
