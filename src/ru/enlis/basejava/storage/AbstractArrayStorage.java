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
        int index = indexInStorage(resume.getUuid());
        if (size == MAX_SIZE) {
            System.out.println("Хранилище резюме заполнено.");
        } else if (index >= 0) {
            System.out.println("Резюме " + resume.getUuid() + " уже существует.");
        } else {
            saveInOrder(resume, index);
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
            deleteSavingOrder(indexInStorage);
            size--;
        } else {
            System.out.println("Резюме " + uuid + " нет.");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int indexInStorage(String uuid);

    protected abstract void saveInOrder(Resume resume, int indexInStorage);

    protected abstract void deleteSavingOrder(int indexInStorage);
}