package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, storageSize, null);
        storageSize = 0;
    }

    public void save(Resume r) {
        if (storageSize != storage.length) {
            if (searchIndexByUuid(r.getUuid()) == -1) {
                storage[storageSize] = r;
                storageSize++;
            }
        } else {
            System.out.println("Storage is full. Please clear space!");
        }
    }

    public void update(Resume r) {
        if (searchIndexByUuid(r.getUuid()) != -1) {
            storage[searchIndexByUuid(r.getUuid())] = r;
        }
    }

    public void delete(String uuid) {
        if (searchIndexByUuid(uuid) != -1) {
            storage[searchIndexByUuid(uuid)] = storage[storageSize - 1];
            storage[storageSize - 1] = null;
            --storageSize;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, storageSize);
    }


    protected int searchIndexByUuid(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        System.out.println("Resume " + uuid + " not presents.");
        return -1;
    }
}