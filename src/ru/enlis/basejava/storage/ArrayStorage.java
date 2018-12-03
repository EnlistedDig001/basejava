package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int indexInStorage = indexInStorage(resume.getUuid());
        if (size < MAX_SIZE) {
            if (indexInStorage == -1) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("Уже есть такое резюме.");
            }
        } else {
            System.out.println("Хранилище резюме заполнено.");
        }
    }

    public void delete(String uuid) {
        int indexInStorage = indexInStorage(uuid);
        if (indexInStorage != -1) {
            storage[indexInStorage] = null;
            size--;
            storage[indexInStorage] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Такого резюме нет.");
        }
    }

    public void update(Resume resume) {
        int indexInStorage = indexInStorage(resume.getUuid());
        if (indexInStorage != -1) {
            storage[indexInStorage] = resume;
        } else {
            System.out.println("Такого резюме нет.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] storageCopy = new Resume[size];
        System.arraycopy(storage, 0, storageCopy, 0, size);
        return storageCopy;
    }

    protected int indexInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}