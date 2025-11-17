/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		
		// If the strings have different lengths, they cannot be anagrams.
		if (str1.length() != str2.length()) {
			return false;
		}

		// remove evrey letter in str1 from str2
		// since we remove letters from str2, its length will decrease
		// so we use str1.length() as the loop limit and only refrence the first char of str1
		// for mutueability issues
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			if (str2.indexOf(str1.charAt(0)) == -1){
				return false;
			} else {
				// ""+ is used to convert char to string
				// str2 is delt first to avoid index shifting
				str2 = str2.replaceFirst(""+str1.charAt(0), "");
				str1 = str1.replaceFirst(""+str1.charAt(0), "");
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		char c;
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (Character.isLetter(c)) {
				c = Character.toLowerCase(c);
			} else // if (c != ' ') {
			// 	continue;
			// }} else if (c != ' ') {
				{continue;
			}
			result += c;
		} 		
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		double rand = Math.random();
		int pos = (int)(rand * str.length());
		char c = str.charAt(pos);
		String firstPart = str.substring(0, pos);
		String secondPart = str.substring(pos + 1, str.length());
		if (rand > 0.5){
			return firstPart + secondPart + c;
		}else{
			return c + firstPart + secondPart;
		}
	}
}
