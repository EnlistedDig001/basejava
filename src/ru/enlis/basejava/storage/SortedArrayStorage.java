package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

import java.util.Arrays;

/**
 * Sorted array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    protected void saveInOrder(Resume resume, int index) {
        index = -(index) - 1;

        System.arraycopy(storage, index, storage, ++index, size - (--index));
        storage[index] = resume;
    }

    protected void deleteSavingOrder(int index) {
        System.arraycopy(storage, ++index, storage, --index, size - (--index));
    }

    protected int indexInStorage(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
