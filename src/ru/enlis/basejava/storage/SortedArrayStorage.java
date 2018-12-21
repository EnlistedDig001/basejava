package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

import java.util.Arrays;

/**
 * Sorted array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    protected void saveInOrder(Resume resume, int index) {
        int reversedIndex = -(index) - 1;

        System.arraycopy(storage, reversedIndex, storage, reversedIndex + 1, size - reversedIndex);
        storage[reversedIndex] = resume;
    }

    protected void deleteSavingOrder(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index - 1);
    }

    protected int indexInStorage(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
