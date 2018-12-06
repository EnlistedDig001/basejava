package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected int MAX_SIZE = 10_000;
    protected Resume[] storage = new Resume[MAX_SIZE];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
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

    public Resume[] getAll() {
        Resume[] storageCopy = new Resume[size];
        System.arraycopy(storage, 0, storageCopy, 0, size);
        return storageCopy;
    }

    protected abstract int indexInStorage(String uuid);
}