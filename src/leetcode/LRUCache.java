/**
 * @created Nov 2, 2014
 * @updated Sep 9, 2015
 * @author franklsf95
 * 
 * @problem lru-cache
 * @difficulty hard
 */

package leetcode;

import java.util.*;

// The implementation of a LRUCache is Double-Linked List Nodes embedded
// in a Hash Map. Nodes rearrange during a "get" operation.
// Note: double-linked list is necessary to avoid Time Limit Exceeded Error

public class LRUCache {
	
	private class Node {
		int key;
		int value;
		Node prev;
		Node next;
		
		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}
	
	private HashMap<Integer, Node> store;
	private Node head;  // The first node, i.e. the least recently used one
	private Node tail;  // The last node, i.e. the most recently used one
	private int capacity;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		store = new HashMap<Integer, Node>(capacity);
	}
	
	public int get(int key) {
		// Get node
		Node node = store.get(key);
		if (node == null) {
			return -1;
		}
		// Rearrange nodes
		moveToLast(node);
		return node.value;
	}
	
	public void set(int key, int value) {
		// Get node
		Node node = store.get(key);
		if (node == null) {
			// Add a node
			node = createAndAppendNode(key, value);			
			if (store.size() == capacity) {
				// Remove the head node
				store.remove(head.key);
				head = head.next;
			}
			// Insert the node into hash map
			store.put(key, node);
		}
		// Update node
		node.value = value;
		moveToLast(node);
	}
	
	// Create a node and append it to the linked list
	private Node createAndAppendNode(int key, int value) {
		Node node = new Node();
		node.key = key;
		node.value = value;
		
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
		}
		
		return node;
	}
	
	// Move the node to last, indicating most recent use
	private void moveToLast(Node node) {
//		System.err.println("Moving " + node + " to last");
		
		if (node == tail) {
			// Already is last node
			return;
		}
		
//		System.err.println("Before---");
//		printLinkedList();

		if (node == head) {
			// Change head (we guaranteed head != tail)
			head = head.next;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		node.prev = tail;
		node.next = null;
		tail.next = node;
		tail = node;
		
//		System.err.println("After---");
//		printLinkedList();
	}
	
	@SuppressWarnings("unused")
	private void printLinkedList() {
		System.err.print("Linked List: ");
		Node runner = head;
		while (runner != null && runner.next != null) {
			System.err.print(runner + " -> ");
			runner = runner.next;
		}
		System.err.println(runner);
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
