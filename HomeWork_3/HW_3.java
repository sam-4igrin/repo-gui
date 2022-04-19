package HomeWork_3;

import java.util.*;

public class HW_3 {
    public static void main(String[] args) {
        slova();
        Phone();
    }

    private static void slova() {
        Map<String, Integer> hm = new HashMap<>();
        String[] words = {
                "honour", "clutch",
                "opposite", "century",
                "phone", "phone",
                "clutch", "clutch",
                "fat", "phone",
                "million", "clutch",
                "serve", "century",
                "century", "phone",
                "comfortable", "clutch",
                "examine", "phone"

        };

        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i]))
                hm.put(words[i], hm.get(words[i]) + 1);
            else
                hm.put(words[i], 1);
        }
        System.out.println(hm);
    }

    private static void Phone() {
        Person List_person = new Person();

        List_person.add("Ivanov", "+79250000001");
        List_person.add("Petrov", "+79250000002");
        List_person.add("Sviridov", "+79250000003");
        List_person.add("Ivanov", "+79250000004");
        List_person.add("Ivanov", "+79250000005");
        List_person.add("Ivanov", "+79250000006");
        List_person.add("Petrov", "+79250000007");
        List_person.add("Ivanov", "+79250000008");

        System.out.print("Ivanov: ");
        System.out.println(List_person.get("Ivanov"));
        System.out.print("Petrov: ");
        System.out.println(List_person.get("Petrov"));
        System.out.print("Sviridov: ");
        System.out.println(List_person.get("Sviridov"));
    }
}


