import com.sun.org.apache.bcel.internal.generic.ATHROW;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
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
            if ((storage[i].uuid.equals(uuid)) & (i != storageSize - 1)) {
                storage[i] = storage[storageSize - 1];
                storage[storageSize - 1] = null;
                --storageSize;
            }
        }
    }

    Resume[] getAll() {
        Resume[] allResume = new Resume[storageSize];
        for (int i = 0; i < storageSize; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    int size() {
        return storageSize;
    }
}