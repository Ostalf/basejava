package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    public void clear() {
        Arrays.fill(storage, null);
        storageSize = 0;
    }

    public void save(Resume r) {
        storage[storageSize] = r;
        storageSize++;
    }


    public Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                return resume;
            } else {
                return new Resume();
            }
        }
        return new Resume();
    }

    public void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[storageSize - 1];
                storage[storageSize - 1] = null;
                --storageSize;
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, storageSize);
    }

    public int size() {
        return storageSize;
    }
}