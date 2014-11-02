import java.util.*;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer val = super.get(key);
        if (val == null) {
            return -1;
        } else {
            return val;
        }
    }

    public void set(int key, int value) {
        put(key, value);
    }

    protected boolean removeEldestEntry(Map.Entry e) {
        // System.out.println(size() + " >? " + capacity);
        return size() > capacity;
     }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(3);
        c.set(1, 10);
        c.set(2, 20);
        c.set(3, 30);
        c.set(4, 40);
        System.out.println(c.get(1) + " = -1 (1)");
        System.out.println(c.get(2) + " = 20");
        c.set(5, 50);
        System.out.println(c.get(3) + " = -1 (3)");
        System.out.println(c.get(4) + " = 40");
    }
}
