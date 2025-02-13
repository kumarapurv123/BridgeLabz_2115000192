import java.util.*;

class MyHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int SIZE = 16;
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[SIZE];
    }

    private int getHash(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int hash = getHash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> current = table[hash];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newEntry;
        }
    }

    public V get(K key) {
        int hash = getHash(key);
        Entry<K, V> current = table[hash];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int hash = getHash(key);
        Entry<K, V> current = table[hash];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[hash] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println(map.get("one"));
        map.remove("one");
        System.out.println(map.get("one"));
    }
}
