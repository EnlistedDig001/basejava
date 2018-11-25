import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int MAX_SIZE = 10_000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume resume) {
        int resumeNumInStorage = resumeNumInStorage(resume.uuid);
        if (size < MAX_SIZE) {
            if (resumeNumInStorage == -1) {
                storage[size] = resume;
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
        if (resumeNumInStorage != -1) {
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
        Resume[] storageCopy = new Resume[size];
        System.arraycopy(storage, 0, storageCopy, 0, size);
        return storageCopy;
    }


}