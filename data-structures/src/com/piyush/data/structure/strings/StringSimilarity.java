package com.piyush.data.structure.strings;

public class StringSimilarity {
	
	private static int[] zFunc(String s) {
		int[] res = new int[s.length()];
		int left = 0;
		int right = 0;
		for (int i = 1; i < s.length(); ++i) {
			System.out.println("Iteration number...." + i);
			if (i <= right) {
				System.out.println("right - i + 1 = " + (right - i + 1));
				System.out.println("res[i - left] = " + res[i-left]);
				res[i] = Math.min(right - i + 1, res[i - left]);
				System.out.println("if loop res[i] = " + res[i]);
			}
			
			System.out.println("res[i] = " + res[i] + " :: i + res[i] = " + (i + res[i]));
			System.out.println(s.charAt(res[i]) + " == " + s.charAt(i + res[i]));
			while (i + res[i] < s.length() && s.charAt(res[i]) == s.charAt(i + res[i])) {
				System.out.println(s.charAt(res[i]) + " == " + s.charAt(i + res[i]));
				++res[i];
				System.out.println("while loop = " + res[i]);
			}

			if (i + res[i] - 1 > right) {
				left = i;
				right = i + res[i] - 1;
				System.out.println("left = " + left);
				System.out.println("right = " + right);
			}
			
			System.out.println("result = " + res[i]);
			System.out.println();
		}
		
		/*for(int i=0; i<res.length; i++)
			System.out.println(res[i]);*/
		return res;
	}

	public static void main(String[] args) {
		zFunc("ababaa");
	}


}
