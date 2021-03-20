package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int storageSize = 0;

    public int size() {
        return storageSize;
    }

    public Resume get(String uuid) {
        int index = searchIndexByUuid(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            return new Resume();
        }
    }

    protected abstract int searchIndexByUuid(String uuid);

}