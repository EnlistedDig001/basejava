package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int MAX_SIZE = 10_000;
    private Resume[] storage = new Resume[MAX_SIZE];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int resumeNumInStorage = resumeNumInStorage(resume.getUuid());
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

    public Resume get(String uuid) {
        int resumeNumInStorage = resumeNumInStorage(uuid);
        if (resumeNumInStorage != -1) {
            return storage[resumeNumInStorage];
        } else {
            System.out.println("Такого резюме нет.");
            return null;
        }
    }

    public void delete(String uuid) {
        int resumeNumInStorage = resumeNumInStorage(uuid);
        if (resumeNumInStorage != -1) {
            storage[resumeNumInStorage] = null;
            size--;
            storage[resumeNumInStorage] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Такого резюме нет.");
        }
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        int resumeNumInStorage = resumeNumInStorage(resume.getUuid());
        if (resumeNumInStorage != -1) {
            storage[resumeNumInStorage] = resume;
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

    private int resumeNumInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}