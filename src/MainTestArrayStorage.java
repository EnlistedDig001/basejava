/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.uuid = "uuid1";
        Resume r2 = new Resume();
        r2.uuid = "uuid2";
        Resume r3 = new Resume();
        r3.uuid = "uuid3";
        Resume r5 = new Resume();
        r5.uuid = "uuid5";

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r5);

        System.out.println("Get r3: " + ARRAY_STORAGE.get(r3.uuid));
        System.out.println("Get r5: " + ARRAY_STORAGE.get(r5.uuid));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        printAll();

        System.out.println("Delete r3");
        ARRAY_STORAGE.delete(r3.uuid);
        printAll();

        System.out.println("Update r5");
        ARRAY_STORAGE.update(r5);
        printAll();

        System.out.println("Clear");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Save r2");
        ARRAY_STORAGE.save(r2);
        printAll();
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
