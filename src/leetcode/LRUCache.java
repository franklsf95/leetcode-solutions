/**
 * @created Nov 2, 2014
 * @author franklsf95
 * 
 * @problem lru-cache
 * @difficulty hard
 */

package leetcode;

import java.util.*;

public class LRUCache {
	
	private static final boolean DEBUG = true;
	
	class Node {
		Node prev;
		Node next;
		int key;
		int value;
		Node(int k, int v) {
			key = k;
			value = v;
		}
	}
	
	private HashMap<Integer, Node> lookup;
	private int capacity;
	private Node head;
	private Node last;

    public LRUCache(int c) {
        lookup = new HashMap<Integer, Node>(c);
        capacity = c;
        head = null;
        last = null;
    }
    
    private void moveToLast(Node n) {
    	if (n != last) {
    		if (n == head) {
        		head = n.next;
        	}
        	if (n.prev != null) {
        		n.prev.next = n.next;
        	}
        	if (n.next != null) {
        		n.next.prev = n.prev;
        	}
        	n.prev = last;
        	n.next = null;
        	if (last != null) {
        		last.next = n;
        	}
        	last = n;
    	}
    }
    
    public int get(int key) {
        if (DEBUG) print();
    	Node n = lookup.get(key);
    	if (n == null) {
    		return -1;
    	}
    	moveToLast(n);
    	return n.value;
    }
    
    public void set(int key, int value) {
    	if (DEBUG) print();
    	Node existing = lookup.get(key);
    	if (existing != null) {
    		existing.value = value;
    		moveToLast(existing);
    		return;
    	}
        Node n = new Node(key, value);
        if (last == null) {
        	head = last = n;
        } else {
        	n.prev = last;
        	last.next = n;
        	last = n;
        }
        lookup.put(key, n);
        if (DEBUG) System.out.printf("%d entered\n", key);
        if (lookup.size() > capacity) {
        	// drop first node
        	if (head != null) {
        		if (DEBUG) System.out.printf("%d evicted\n", head.key);
        		if (head.next != null) {
        			head.next.prev = null;
        		}
        		lookup.remove(head.key);
        		head = head.next;
        	} else {
        		if (DEBUG) System.out.println("Nothing to evict");
        	}
        }
    }
    
    public void print() {
		Node runner = head;
		while (runner != null) {
			System.out.printf("%d ", runner.key);
			runner = runner.next;
		}
		System.out.println();
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
        System.out.println("-----------");
        
        c = new LRUCache(2);
        c.set(2,1);
        c.set(1,1);
        c.set(2,3);
        c.set(4,1);
        System.out.printf("%d = -1 (1)\n", c.get(1));
        System.out.printf("%d = 3 (2)\n", c.get(2));
    }

}
