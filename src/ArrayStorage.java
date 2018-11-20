import java.util.Arrays;
import java.util.WeakHashMap;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }

        storage[i] = r;
    }

    Resume get(String uuid) {
        if (uuid.contains("uuid")) {
            int id = (Integer.parseInt(uuid.replaceAll("uuid", "")))-1;
            return storage[id];
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        int i = 0;
        while (storage[i].uuid != uuid) {
            i++;

            if (i > 10000) {
                break;
            }
        }

        storage[i] = null;
    }

    int size() {
        int n = 0;
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                n = i;
                break;
            }
        }
        return n;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storage = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            this.storage[i] = storage[i];
        }
        return this.storage ;
    }


}
