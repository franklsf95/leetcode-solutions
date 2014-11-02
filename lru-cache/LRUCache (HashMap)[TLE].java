import java.util.*;

public class LRUCache {

    class Entry {
        int val;
        int lastUse;
        Entry(int v, int l) {
            val = v;
            lastUse = l;
        }
    }

    private HashMap<Integer, Entry> g;
    private int capacity;
    private static int time = 0;

    public LRUCache(int capacity) {
        g = new HashMap<Integer, Entry>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        time++;
        Entry e = g.get(key);
        if (e != null) {
            e.lastUse = time;
            return e.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        time++;
        Entry e = g.get(key);
        if (e != null) {
            e.lastUse = time;
            e.val = value;
        } else {
            if (g.size() == capacity) {
                int eldestKey = -1;
                int eldestTime = 0x7fffffff;
                int use;
                for (Map.Entry<Integer, Entry> me: g.entrySet()) {
                    use = me.getValue().lastUse;
                    if (use < eldestTime) {
                        eldestTime = use;
                        eldestKey = me.getKey();
                    }
                }
                g.remove(eldestKey);
            }
            g.put(key, new Entry(value, time));
        }
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
