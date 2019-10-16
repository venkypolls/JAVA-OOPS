package Algorithms;

public class AnagramsQuora {

	static boolean areAnagram(String str1, String str2) 
	{ 
		// If two strings have different length 
		if (str1.length() != str2.length()) 
		{ 
			return false; 
		} 

		// To store the xor value 
		int value = 0; 

		for (int i = 0; i < str1.length(); i++) 
		{ 
			value = value ^ (int) str1.charAt(i); 
			value = value ^ (int) str2.charAt(i); 
		} 

		return value == 0; 

	} 
	public static void main(String[] args) {
	
			String str1 = "55"; 
			String str2 = "11"; 
			if (areAnagram(str1, str2)) 
				System.out.println("The two strings are anagram of each other"); 
			else
				System.out.println("The two strings are not anagram of each other"); 

		
	}

}
