import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }

        storage[i] = r;

        size++;
    }

    Resume get(String uuid) {
        if (uuid.contains("uuid")) {
            for (int i = 0; i < 10000; i++) {
                if (storage[i].uuid == uuid) {
                    return storage[i];
                }
            }
        }
        return null;

    }

    void delete(String uuid) {
        for (int i = 0; i < 10000; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid == uuid) {
                    storage[i] = null;

                    for (int j = i; j < size;) {
                        storage[j] = storage[++j];
                    }
                }
            }
        }
    }

    int size() {
        if (size == 0) {
            for (int i = 0; i < 10000; i++) {
                if (storage[i] == null) {
                    size = i;
                    break;
                }
            }
        }

        return size;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storage = new Resume[size];
        for (int i = 0; i < size; i++) {
            storage[i] = this.storage[i];
        }
        return storage ;
    }


}
