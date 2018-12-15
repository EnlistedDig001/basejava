package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

import java.util.Arrays;

/**
 * Sorted array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    protected void saveInOrder(Resume resume) {
        int i = 0;
        while ((i < size) && (Integer.parseInt(resume.getUuid()) > Integer.parseInt(storage[i].getUuid()))) {
            i++;
        }

        for (int j = size; j > i; j--) {
            storage[j] = storage[--j];
            j++;
        }

        storage[i] = resume;
    }

    protected void deleteSavingOrder(String uuid, int indexInStorage) {
        for (int i = indexInStorage; i < size; i++) {
            storage[i] = storage[++i];
            i--;
        }
    }

    protected int indexInStorage(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
