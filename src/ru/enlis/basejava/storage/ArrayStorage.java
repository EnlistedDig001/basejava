package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected void saveInOrder(Resume resume) {
        storage[size] = resume;
    }

    protected void deleteSavingOrder(String uuid, int indexInStorage) {
        storage[indexInStorage] = null;
        storage[indexInStorage] = storage[size - 1];
        storage[size - 1] = null;
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