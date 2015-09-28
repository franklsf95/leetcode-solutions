/**
 * @created Sep 16, 2015
 * @author franklsf95
 * 
 * @problem merge-k-sorted-lists
 * @difficulty hard
 */
package leetcode;

import java.util.*;

public class KthLargestElementInAnArray {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		
		void print() {
			if (next != null) {
				System.out.print(val + ", ");
				next.print();
			} else {
				System.out.println(val);
			}
		}
	}
	
	static class Item implements Comparable<Item> {
		int val;
		int index;
		Item(int v, int i) {
			val = v;
			index = i;
		}
		
		@Override
		public int compareTo(Item o) {
			return val - o.val;
		}
		
		@Override
		public String toString() {
			return val + " (" + index + ")";
		}
	}
	
	// Time Complexity: K*N (N is the total number of items)
	static ListNode mergeKLists(ListNode[] lists) {
		final int K = lists.length;
		if (K == 0) {
			return null;
		}		
		// A priority queue of items from each of the lists
		PriorityQueue<Item> q = new PriorityQueue<Item>(K);
		// An list of node pointers indicating current progress of a list
		ListNode[] currs = new ListNode[K];
		// The head of the new, merged, sorted linked list
		ListNode ret = new ListNode(-1);
		// The current last item in the `ret` linked list
		ListNode last = ret;
		// When the counter reaches K, we are done
		int exhausted = 0;
		
		// Fill the queue with initial elements
		for (int i = 0; i < K; i++) {
			ListNode node = lists[i];
			if (node == null) {
				exhausted++;
			} else {
				Item item = new Item(node.val, i);
				q.add(item);
				currs[i] = node.next;
			}
		}		
		while (exhausted < K) {
			// The currently least item
			Item least = q.poll();
			if (least == null) {
				break;
			}
			// Add it in the new array
			ListNode node = new ListNode(least.val);
			last.next = node;
			last = node;
			// Poll new item from the same linked list
			int index = least.index;
			ListNode list = currs[index];
			if (list == null) {
				exhausted++;
			} else {
				Item item = new Item(list.val, index);
				q.add(item);
				// Update the `currs` array
				currs[index] = list.next;
			}
			System.out.printf("ret = ");
			ret.next.print();
			System.out.println("Queue = " + q);
		}
        return ret.next;
    }

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(6);
		ListNode a3 = new ListNode(7);
		ListNode a4 = new ListNode(8);
		ListNode a5 = new ListNode(9);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(2);
		ListNode b3 = new ListNode(3);
		ListNode b4 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(4);
		ListNode c3 = new ListNode(5);
		ListNode c4 = new ListNode(10);
		c1.next = c2;
		c2.next = c3;
		c3.next = c4;
		ListNode[] lists = {a1, b1, c1};
		
		a1.print();
		b1.print();
		c1.print();
		System.out.println("================");
		ListNode ret = mergeKLists(lists);
		ret.print();
	}

}
