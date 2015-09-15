/**
 * @created Sep 15, 2015
 * @author franklsf95
 * 
 * @problem copy-list-with-random-pointer
 * @difficulty hard
 */

package leetcode;

import java.util.*;

public class CopyListWithRandomPointer {

	static class RandomListNode {
		int label;
		RandomListNode next, random;
		
		RandomListNode(int x) {
			label = x;
		}
		
		public String toString() {
			return "[" + label + "] " + (System.identityHashCode(this) % 1000000);
		}
		
		void print() {
			System.out.println(this + ", random = " + random);
			if (next != null) {
				next.print();
			}
		}
	}
	
	static RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		if (head == null) {
			return null;
		}
        RandomListNode head_ = new RandomListNode(head.label);
        RandomListNode runner = head.next;
        RandomListNode prev_ = head_;
        map.put(head, head_);
        while (runner != null) {
        	RandomListNode curr_ = new RandomListNode(runner.label);
        	prev_.next = curr_;
        	// Save curr_ into map
        	map.put(runner, curr_);
        	// Iterate
        	prev_ = curr_;
        	runner = runner.next;
        }
        for (RandomListNode node: map.keySet()) {
        	RandomListNode node_ = map.get(node);
        	RandomListNode random_ = map.get(node.random);
        	node_.random = random_;
        }
        
        return head_;
    }
	
	public static void main(String[] args) {
		RandomListNode a = new RandomListNode(1);
		RandomListNode b = new RandomListNode(2);
		RandomListNode c = new RandomListNode(3);
		RandomListNode d = new RandomListNode(4);
		a.next = b;
		a.random = a;
		b.next = c;
		b.random = null;
		c.next = d;
		c.random = d;
		d.next = null;
		d.random = b;
		a.print();
		
		System.out.println("---------------");
		RandomListNode a_ = copyRandomList(a);
		a_.print();
	}
}
