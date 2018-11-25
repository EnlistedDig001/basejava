import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    private int resumeNumInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        int resumeNumInStorage = resumeNumInStorage(r.uuid);
        if (size < 10000) {
            if (resumeNumInStorage == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Уже есть такое резюме.");
            }
        } else {
            System.out.println("Хранилище резюме заполнено.");
        }
    }

    Resume get(String uuid) {
        int resumeNumInStorage = resumeNumInStorage(uuid);
        if (resumeNumInStorage != -1){
            return storage[resumeNumInStorage];
        } else {
            System.out.println("Такого резюме нет.");
            return null;
        }
    }

    void delete(String uuid) {
        int resumeNumInStorage = resumeNumInStorage(uuid);
        if (resumeNumInStorage != -1) {
            storage[resumeNumInStorage] = null;
            for (int j = resumeNumInStorage; j < size;) {
                storage[j] = storage[++j];
            }
            size--;
        } else {
            System.out.println("Такого резюме нет.");
        }
    }

    int size() {
        return size;
    }

    void update(Resume oldResume, Resume newResume) {
        int resumeNumInStorage = resumeNumInStorage(oldResume.uuid);
        if (resumeNumInStorage != -1) {
            storage[resumeNumInStorage] = newResume;
            System.out.println("Обновлено.");
        } else {
            System.out.println("Такого резюме нет.");
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