import java.util.ArrayList;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        if (uuid.contains("uuid")) {
            int id = Integer.parseInt(uuid.replaceAll("uuid", ""));
            return storage[id];
        } else {
            return null;
        }
    }

    void delete(String uuid) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    ArrayList getAll() {

        /*ArrayList resumes = new ArrayList(0);;
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                resumes.add(storage[i]);
            }
        }*/
        return null;
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
}
