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

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int indexInStorage = indexInStorage(resume.getUuid());
        if (indexInStorage > -1) {
            storage[indexInStorage] = resume;
        } else {
            System.out.println("Резюме " + resume.getUuid() + " отсутствует.");
        }
    }

    public void save(Resume resume) {
        if (size == 0) {
            storage[0] = resume;
            size++;
        } else if (size == MAX_SIZE) {
            System.out.println("Хранилище резюме заполнено.");
        } else if (indexInStorage(resume.getUuid()) >= 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже существует.");
        } else {
            saveInOrder(resume);
            size++;
        }
    }

    public Resume get(String uuid) {
        int indexInStorage = indexInStorage(uuid);
        if (indexInStorage > -1) {
            return storage[indexInStorage];
        } else {
            System.out.println("Резюме " + uuid + " нет.");
            return null;
        }
    }

    public void delete(String uuid) {
        int indexInStorage = indexInStorage(uuid);
        if (indexInStorage > -1) {
            deleteSavingOrder(uuid, indexInStorage);
            size--;
        } else {
            System.out.println("Резюме " + uuid + " нет.");
        }
    }

    public Resume[] getAll() {
        Resume[] storageCopy = new Resume[size];
        System.arraycopy(storage, 0, storageCopy, 0, size);
        return storageCopy;
    }

    public int size() {
        return size;
    }

    protected abstract int indexInStorage(String uuid);

    protected abstract void saveInOrder(Resume resume);

    protected abstract void deleteSavingOrder(String uuid, int indexInStorage);
}