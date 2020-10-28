package datastructures.hashtable;

public class HashTable<K, V> {

    // Number of buckets in hash table
    private final int N = 1001;

    protected HashList[] list;

    public HashTable() {
        this.list = new HashList[N];
    }

    private int hash(K key) {
        if(key instanceof Integer) {
            return ((Integer) key).intValue() % N;
        }
        return key.hashCode() % N;
    }

    private void add(K key, V value) {
        int hash = this.hash(key);

        if(list[hash] == null) {
            list[hash] = new HashList<>();
        }
        list[hash].addNode(new HashListNode<>(key, value));
    }

    private boolean exists(K key) {
        int hash = this.hash(key);

        if(list[hash] == null) {
            return false;
        }
        return list[hash].findNode(key) != null;
    }

    private V get(K key) {
        int hash = this.hash(key);

        if(list[hash] == null) {
            return null;
        }
        HashListNode node = list[hash].findNode(key);
        if(node != null) {
            return (V) node.getValue();
        }
        return null;
    }

    private boolean remove(K key) {
        int hash = this.hash(key);

        if(list[hash] == null) {
            return false;
        }

        return list[hash].removeNode(key);
    }

    private void printTable() {
        for(int i = 0; i < N; i++) {
            if(list[i] != null) {
                HashListNode<K, V> cursor = list[i].getHead();

                while(cursor != null) {
                    System.out.println("[Key: " + cursor.getKey() + " - Value: " + cursor.getValue() + "]");
                    cursor = cursor.getNext();
                }
            }
        }
    }

    public static void main(String[] args) {

        HashTable<String,String> hashTableString = new HashTable<>();
        HashTable<Integer,Integer> hashTableInt = new HashTable<>();

        hashTableString.add("Guilherme", "1");
        hashTableString.add("Guilherme", "2");
        hashTableString.add("Camila", "3");

        hashTableInt.add(100, 200);
        hashTableInt.add(500, 600);
        hashTableInt.add(600, 700);

        hashTableString.printTable();
        hashTableInt.printTable();

        System.out.println(hashTableString.get("gui"));
        System.out.println(hashTableString.get("Camila"));

    }
}
