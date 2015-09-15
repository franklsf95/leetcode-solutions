/**
 * @created Sep 15, 2015
 * @author franklsf95
 * 
 * @problem implement-trie-prefix-tree
 * @difficulty medium
 */

package leetcode;

import java.util.*;

class TrieNode {
	static char TERM = '$';
	char value;
	List<TrieNode> children;
	
    public TrieNode() {
    	value = 0;
        children = new ArrayList<TrieNode>();
    }
    
    // Insert the word into trie, starting from index
    public void insert(char[] word, int index) {
    	if (index > word.length) {
    		return;
    	}
    	char value;
    	if (index == word.length) {
    		value = TERM;
    	} else {
    		value = word[index];
    	}
    	for (TrieNode child: children) {
			if (child.value == value) {
				child.insert(word, index + 1);
				return;
			}
		}
    	// No child present, insert new node
    	TrieNode node = new TrieNode();
    	node.value = value;
    	children.add(node);
    	node.insert(word, index + 1);
    }
    
    // Strict for search, non-strict for prefix search
    public boolean search(char[] word, int index, boolean strict) {
    	if (index == word.length) {
    		if (strict) {
    			// If the word ends but no termination node exists, then the search fails
    			for (TrieNode child: children) {
    				if (child.value == TERM) {
    					return true;
    				}
    			}
    			return false;
    		} else {
    			return true;
    		}
    	}
    	for (TrieNode child: children) {
    		if (child.value == word[index]) {
    			// Search into that branch
    			return child.search(word, index + 1, strict);
    		}
    	}
    	return false;
    }
    
    public void print(int indent) {
    	for (int i = 0; i < indent; i++) {
    		System.out.print("  ");
    	}
    	System.out.println(value);
    	for (TrieNode child: children) {
    		child.print(indent + 1);
    	}
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word.toCharArray(), 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word.toCharArray(), 0, true);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.search(prefix.toCharArray(), 0, false);
    }
    
    public static void main(String[] args) {
    	 Trie trie = new Trie();
    	 trie.insert("somestring");
    	 trie.insert("something");
    	 trie.insert("hello");
    	 trie.insert("helloworld");
    	 System.out.println("search 'key' false = " + trie.search("key"));
    	 System.out.println("search 'hello' true = " + trie.search("hello"));
    	 System.out.println("search 'sometring' false = " + trie.search("sometring"));
    	 System.out.println("search 'somethinga' false = " + trie.search("somethinga"));
    	 System.out.println("search 'he' false = " + trie.search("he"));
    	 System.out.println("startsWith 'ha' false = " + trie.startsWith("ha"));
    	 System.out.println("startsWith 'he' true = " + trie.startsWith("he"));
    	 System.out.println("startsWith 'hello' true = " + trie.startsWith("hello"));
    	 trie.root.print(0);
    	 
    	 Trie t2 = new Trie();
    	 t2.insert("abc");
    	 System.out.println("search 'abc' true = " + t2.search("abc"));
    	 System.out.println("search 'ab' false = " + t2.search("ab"));
    	 t2.insert("ab");
    	 System.out.println("search 'ab' true = " + t2.search("ab"));
    	 t2.insert("ab");
    	 System.out.println("search 'ab' true = " + t2.search("ab"));
    }
}
