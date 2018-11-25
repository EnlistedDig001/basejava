import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    private Integer resumeNumInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
       if (size < 10000) {
            if (resumeNumInStorage(r.uuid) == null) {
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
        if (resumeNumInStorage(uuid) != null){
            return storage[resumeNumInStorage(uuid)];
        } else {
            System.out.println("Такого резюме нет.");
            return null;
        }
    }

    void delete(String uuid) {
        if (resumeNumInStorage(uuid) != null) {
            storage[resumeNumInStorage(uuid)] = null;
            for (int j = resumeNumInStorage(uuid); j < size;) {
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
        if (resumeNumInStorage(oldResume.uuid) != null) {
            storage[resumeNumInStorage(oldResume.uuid)] = newResume;
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
