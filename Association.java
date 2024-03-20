public class Association<K, V> {
    K key;
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }
}