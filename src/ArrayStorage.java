/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (r.uuid == null || r.uuid.equals("")) {
            System.out.println("Error! The field 'uuid' cannot be empty.");
        } else {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) break;
            if (storage[i].uuid.equals(uuid)) {
                if (i == storage.length - 1) {
                    storage[i] = null;
                    break;
                }
                for (int j = i; j < size - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                break;
            }
        }
        storage[size - 1] = null;
        size--;
    }

    Resume[] getAll() {
        Resume[] allResume = new Resume[size];
        for (int i = 0; i < size; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    int size() {
        return size;
    }
}
