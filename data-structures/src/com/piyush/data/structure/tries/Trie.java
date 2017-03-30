package com.piyush.data.structure.tries;

class TrieNode {
	
	TrieNode[] children;
	boolean isWord;
	
	public TrieNode() {
		this.children = new TrieNode[26];
		this.isWord = false;
	}
}

public class Trie {

	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void addWord(TrieNode root, String str) {
		
		if(str.isEmpty()) {
			root.isWord = true;
			return;
		}
		
		char ch = str.charAt(0);
		int index = ch - 'a';
		
		if(root.children[index] == null) {
			TrieNode node = new TrieNode();
			root.children[index] = node;			
		}
		
		addWord(root.children[index], str.substring(1));
	}
	
	public void addWord(String str) {
		TrieNode p = root;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			int index = ch - 'a';
			if(p.children[index] == null) {
				TrieNode t = new TrieNode();
				p.children[index] = t;
				p = t;
			} else {
				p = p.children[index];
			}
		}
		
		p.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNode node = searchNode(word);
		if(node!=null && node.isWord)
			return true;
		
		return false;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode node = searchNode(prefix);
		if(node!=null)
			return true;
		
		return false;
	}
	
	private TrieNode searchNode(TrieNode root, String str) {
		if(str.isEmpty()) {
			return root;
		}
		
		char ch = str.charAt(0);
		int index = ch - 'a';
		
		if(root.children[index] == null) {
			return null;
		}
		
		return searchNode(root.children[index], str.substring(1));		
	}
	
	private TrieNode searchNode(String str) {
		TrieNode p = root;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			int index = ch - 'a';
			if(p.children[index]==null) {
				return null;
			} else {
				p = p.children[index];
			}
		}
		
		if(p==root)
			return null;
		
		return p;
	}
	
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		String[] dict = {"blimey", "groggy", "haughty", "skulk", "swanky"};
		
		for(String str : dict) {
			trie.addWord(str);
		}
		
		System.out.println(trie.search("haughty"));
		
		System.out.println(trie.startsWith("hau"));
		
		String str = "shkvcswankywm";
		
		for(int i=0; i<str.length()-1; i++) {
			for(int j=i+1; j<str.length(); j++) {
				if(trie.search(str.substring(i,j))) {
					System.out.println("True");
					break;
				}			
			}
		}
		
	}
	
}
