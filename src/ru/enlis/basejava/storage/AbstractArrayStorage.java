package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage {
    protected int MAX_SIZE = 10_000;
    protected Resume[] storage = new Resume[MAX_SIZE];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int indexInStorage = indexInStorage(uuid);
        if (indexInStorage != -1) {
            return storage[indexInStorage];
        } else {
            System.out.println("Резюме " + uuid + " нет.");
            return null;
        }
    }

    protected abstract int indexInStorage(String uuid);
}