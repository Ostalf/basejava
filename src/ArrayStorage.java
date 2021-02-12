import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        Arrays.fill(storage, null);
        storageSize = 0;
    }

    void save(Resume r) {
        storage[storageSize] = r;
        storageSize++;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                return resume;
            } else {
                return new Resume();
            }
        }
        return new Resume();
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[storageSize - 1];
                storage[storageSize - 1] = null;
                --storageSize;
            }
        }
    }

    Resume[] getAll() {
        return Arrays.copyOf(storage,storageSize);
    }

    int size() {
        return storageSize;
    }
}