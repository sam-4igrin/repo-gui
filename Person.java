package HomeWork_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private Map<String, List<String>> person_hm = new HashMap<>();
    private List<String> person_phone;

    public void add(String surname, String phone_number) {
        if (person_hm.containsKey(surname)) {
            person_phone = person_hm.get(surname);
            person_phone.add(phone_number);
            person_hm.put(surname, person_phone);
        } else {
            person_phone = new ArrayList<>();
            person_phone.add(phone_number);
            person_hm.put(surname, person_phone);
        }
    }

    public List<String> get(String surname) {
        return person_hm.get(surname);
    }
}
