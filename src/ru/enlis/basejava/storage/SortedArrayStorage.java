package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void update(Resume resume) {

    }

    @Override
    public void save(Resume resume) {
        if (size == 0) {
            storage[0] = resume;
            size++;
        } else if (size == MAX_SIZE) {
            System.out.println("Хранилище резюме заполнено.");
        } else {
            int i = 0;
            while ((i < size) && (Integer.parseInt(resume.getUuid()) > Integer.parseInt(storage[i].getUuid()))) {
                i++;
            }

            for (int j = size; j > i; j--) {
                storage[j] = storage[--j];
                j++;
            }

            storage[i] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    protected int indexInStorage(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
