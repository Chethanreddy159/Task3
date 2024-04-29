import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class ContactManager {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email address:");
        String email = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : contacts) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println("----------------------");
            }
        }
    }

    public void editContact() {
        System.out.println("Enter the name of the contact you want to edit:");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Enter new phone number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter new email address:");
                String email = scanner.nextLine();
                contact.setPhoneNumber(phoneNumber);
                contact.setEmail(email);
                System.out.println("Contact edited successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact() {
        System.out.println("Enter the name of the contact you want to delete:");
        String name = scanner.nextLine();
        Contact foundContact = null;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                foundContact = contact;
                break;
            }
        }
        if (foundContact != null) {
            contacts.remove(foundContact);
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    manager.addContact();
                    break;
                case 2:
                    manager.viewContacts();
                    break;
                case 3:
                    manager.editContact();
                    break;
                case 4:
                    manager.deleteContact();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
