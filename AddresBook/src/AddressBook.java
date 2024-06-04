import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, Contact> contacts;
    private String filePath;

    public AddressBook(String filePath) {
        this.contacts = new HashMap<>();
        this.filePath = filePath;
        load();
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    contacts.put(parts[0], new Contact(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Contact contact : contacts.values()) {
                bw.write(contact.getNumber() + "," + contact.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public void list() {
        System.out.println("Contactos:");
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    public void create(String number, String name) {
        contacts.put(number, new Contact(number, name));
        save();
    }

    public void delete(String number) {
        contacts.remove(number);
        save();
    }
}
