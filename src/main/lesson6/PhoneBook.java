package src.main.lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
    }

    public void get(String surname) {
        List<String> phones = phoneBook.get(surname);
        if (phones != null && !phones.isEmpty()) {
            System.out.println("Телефоны для фамилии '" + surname + "':");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println((i + 1) + ". " + phones.get(i));
            }
        } else {
            System.out.println("Фамилия '" + surname + "' не найдена.");
        }
    }
}