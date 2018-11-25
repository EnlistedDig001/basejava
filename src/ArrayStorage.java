import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        boolean isDuplicate = false;
        if (size < 10000) {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(r.uuid)) {
                    isDuplicate = true;
                    System.out.println("Уже есть такое резюме.");
                }
            }

            if (!isDuplicate) {
                storage[size] = r;
                size++;
            }
        } else {
            System.out.println("Хранилище резюме заполнено.");
        }

    }

    Resume get(String uuid) {
        for (int i = 0; i <= size; i++) {
            if (i == size) {
                System.out.println("Такого резюме нет.");
            } else if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <= size; i++) {
            if (i == size) {
                System.out.println("Такого резюме нет.");
            } else if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;

                for (int j = i; j < size;) {
                    storage[j] = storage[++j];
                }
                size--;
                break;
            }
        }
    }

    int size() {
        return size;
    }

    void update(Resume oldResume, Resume newResume) {
        for (int i = 0; i <= size; i++) {
            if (i == size) {
                System.out.println("Такого резюме нет.");
            } else if (storage[i].uuid.equals(oldResume.uuid)) {
                storage[i] = newResume;
                System.out.println("Обновлено.");
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storage = new Resume[size];
        System.arraycopy(this.storage, 0, storage, 0, size);
        return storage ;
    }


}
