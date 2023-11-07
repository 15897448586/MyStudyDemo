package Structure;

/**
 * @author zlx
 */
public class HashTable<K,V> {

    private static final int DEFAULT_INIT_CAPACITY = 8;
    private static final float LOADING_FACTOR = 0.75F;
    private Entry<K,V>[] table;
    private int size;
    private int used;

    public HashTable(){
        this.size = 0;
        this.used = 0;
        table = (Entry<K, V>[]) new Entry[DEFAULT_INIT_CAPACITY];
    }

    static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * put a value
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(null, null, null);
        }
        Entry<K, V> temp = table[index];
        if (temp.next == null) {
            temp.next = new Entry<>(key, value, null);
            size++;
            used++;
            if (used > DEFAULT_INIT_CAPACITY *  LOADING_FACTOR) {
                resize();
            }
        }else{
            do{
                temp = temp.next;
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
            }while(temp.next != null);
            Entry<K,V> tmp = table[index].next;
            temp.next = new Entry<>(key, value, tmp);
            size++;

        }
    }

    /**
     * 散列函数
     * @param o key
     * @return
     */
    private int hash(Object o) {
        int h;
        return o == null? 0: ((h = o.hashCode())^(h >>> 16)) % table.length;
    }

    /**
     * 扩容
     */
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table =(Entry<K, V>[]) new Entry[table.length * 2];
        used = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null || table[i].next == null) {
                continue;
            }
            Entry<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hash(e.key);
                if(table[index] == null) {
                    used++;
                    table[index] = new Entry<>(null, null, null);
                }
                table[index].next = new Entry<>(e.key, e.value,table[index].next);
            }
        }
    }

    /**
     * 删除
     *
     * @param key
     */
    public void remove(K key) {
        int index = hash(key);
        Entry e = table[index];
        if (e == null || e.next == null) {
            return;
        }

        Entry pre;
        Entry<K, V> headNode = table[index];
        do {
            pre = e;
            e = e.next;
            if (key == e.key) {
                pre.next = e.next;
                size--;
                if (headNode.next == null) {
                    used--;
                }
                return;
            }
        } while (e.next != null);
    }

    /**
     * 获取
     *
     * @param key
     * @return
     */
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null) {
            return null;
        }
        while (e.next != null) {
            e = e.next;
            if (key == e.key) {
                return e.value;
            }
        }
        return null;
    }
    public int getSize(){
        return this.size;
    }

    public static void main(String[] args) {
        HashTable<Integer,Integer> hashTable =new HashTable<Integer,Integer>();
        hashTable.put(1,3);
        hashTable.put(2,3);
        hashTable.put(3,3);
        hashTable.put(1,3);
        System.out.println(hashTable.get(1));
        hashTable.remove(1);
        hashTable.put(2,4);
        System.out.println(hashTable.getSize());
    }
}
