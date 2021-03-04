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
        Arrays.fill(storage, 0, storageSize, null);
        storageSize = 0;
    }

    public void save(Resume r) {
        if (storageSize != storage.length) {
            if (!presence(r.getUuid())) {
                storage[storageSize] = r;
                storageSize++;
            }
        } else {
            System.out.println("Storage is full. Please clear space!");
        }
    }

    public void update(Resume r) {
        if (presence(r.getUuid())) {
            for (int i = 0; i < storageSize; i++) {
                if (storage[i].getUuid().equals(r.getUuid())) {
                    storage[i] = r;
                    break;
                }
            }
        }
    }

    public Resume get(String uuid) {
        if (presence(uuid)) {
            for (int i = 0; i < storageSize; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                } else {
                    return new Resume();
                }
            }
        }
        return new Resume();
    }

    public void delete(String uuid) {
        if (presence(uuid)) {
            for (int i = 0; i < storageSize; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[storageSize - 1];
                    storage[storageSize - 1] = null;
                    --storageSize;
                }
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, storageSize);
    }

    public int size() {
        return storageSize;
    }

    private boolean presence(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            } else if (storageSize - 1 == i) {
                System.out.println("Resume " + uuid + " not presents. Try again!");
                return false;
            }
        }
        return false;
    }
}