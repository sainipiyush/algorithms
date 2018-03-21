package com.piyush.data.structure.strings;

import java.util.HashMap;
import java.util.HashSet;

/*Given a string, find the longest substring that contains only two unique characters. 
For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character 
is "bcbbbbcccb".*/
public class LongestSubstringWithKUniqueCharacters {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		
		if(s == null || s.length() < 2)
			return -1;
		
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		int start = 0;
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);

			if(map.size() > 2) {
				maxLen = Math.max(maxLen, i-start);
				
				while(map.size() > 2) {
					char st = s.charAt(start);
					int count = map.get(st);
					if(count>1)
						map.put(st, count-1);
					else
						map.remove(st);
					
					start++;					
				}
			}
		}
				
		maxLen = Math.max(maxLen, s.length()-start);
		
		return maxLen;
				
	}
	
	public static int lengthOfLongestSubstringKDistinctCharacters(String s, int k) {
	    if(k==0 || s==null || s.length()==0)
	        return 0;
	 
	    if(s.length()<k)
	        return s.length();
	 
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
	    int maxLen=k;
	    int start=0;
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	 
	        if(map.size()>k){
	            maxLen=Math.max(maxLen, i-start);
	 
	            while(map.size()>k){
	 
	                char fc = s.charAt(start);
	                if(map.get(fc)==1){
	                    map.remove(fc);
	                }else{
	                    map.put(fc, map.get(fc)-1);
	                }
	 
	                start++;
	            }
	        }
	 
	    }
	 
	    maxLen = Math.max(maxLen, s.length()-start);
	 
	    return maxLen;
	}
	
	public static int lengthOfLongestSubstringAllUniqueCharacters(String s) {
		
		if(s==null || s.length()==0)
			return -1;
		
		HashSet<Character> set = new HashSet<>();
		int maxLen = 0;
		int start = 0;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!set.contains(c)) {
				set.add(c);
			} else {
				maxLen = Math.max(maxLen, i - start);
				for(int j=start; j<i; j++){
					char t = s.charAt(j);
	                set.remove(t);
	 
	                if(t==c) {
	                    start=j+1;
	                    break;    
	                }
	            }        
	 
	            set.add(c);
			}
		}
		
		maxLen = Math.max(maxLen, s.length()-start);
				
		return maxLen;
	}
	
	public static void main(String[] args) {
		
		String s = "abcbbbbcccbdddadacb";
		
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
		
		System.out.println(lengthOfLongestSubstringKDistinctCharacters(s, 3));

		System.out.println(lengthOfLongestSubstringAllUniqueCharacters(s));
	}

}
