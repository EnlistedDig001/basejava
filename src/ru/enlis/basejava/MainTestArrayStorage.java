package ru.enlis.basejava;

import ru.enlis.basejava.model.Resume;
import ru.enlis.basejava.storage.ArrayStorage;
import ru.enlis.basejava.storage.SortedArrayStorage;
import ru.enlis.basejava.storage.Storage;

/**
 * Test for your ru.enlis.basejava.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ArrayStorage();
    private static final Storage SORTED_ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("5");
        Resume r2 = new Resume();
        r2.setUuid("1");
        Resume r3 = new Resume();
        r3.setUuid("2");
        Resume r5 = new Resume();
        r5.setUuid("0");

        System.out.println("Save 5");
        SORTED_ARRAY_STORAGE.save(r1);
        printAll();

        System.out.println("Save 1");
        SORTED_ARRAY_STORAGE.save(r2);
        printAll();

        System.out.println("Save 2");
        SORTED_ARRAY_STORAGE.save(r3);
        printAll();

        System.out.println("Save 0");
        SORTED_ARRAY_STORAGE.save(r5);
        printAll();
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : SORTED_ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
