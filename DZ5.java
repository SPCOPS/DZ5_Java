import java.util.*;

public class DZ5 {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Иванов", "111111");
        addContact(phoneBook, "Иванов", "333333");
        addContact(phoneBook, "Сидоров", "444444");
        addContact(phoneBook, "Петров", "555555");
        addContact(phoneBook, "Сидоров", "666666");
        addContact(phoneBook, "Иванов", "777777");
        System.out.println("Телефонная книга:");
        printPhoneBook(phoneBook);
    }
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((a, b) -> b.getValue().size() - a.getValue().size());
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
