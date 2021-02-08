import com.sun.org.apache.bcel.internal.generic.ATHROW;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = size();

    void clear() {
        for (int i = 0; i <storageSize ; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; ) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            } else {
                i++;
            }
        }
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
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                if (i == 0){
                    for (int j = i; j < storageSize; j++) {
                        storage[j] = storage[j+1];
                    }
                    break;
                }
                for (int j = i; j < storageSize; j++) {
                    storage[j-1] = storage[j];
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size()];
        for (int i = 0; i < storageSize; i++) {
            allResume[i] =  storage[i];
        }
        return allResume;
    }

    int size() {
        for (int i = 0; i < storage.length; i++ ) {
            if (storage[i] == null) {
                storageSize = i;
                return i;
            }
        }
        return 0;
    }
}