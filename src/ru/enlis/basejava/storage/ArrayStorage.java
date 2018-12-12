package ru.enlis.basejava.storage;

import ru.enlis.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

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

    protected int indexInStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}