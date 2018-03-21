package com.piyush.data.structure.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class WordNode{
    String word;
    int numSteps;
 
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}
 
public class WordLadder {
	
    public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }
    
    public static void main(String[] args) {
    	
    	Set<String> wordDict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
    	String start = "hit";
    	String end = "cog";
    	System.out.println("Word ladder length from " + start + " --> " + end + " = " + ladderLength(start, end, wordDict));
    	
    }
}


