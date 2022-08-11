import java.util.Hashtable;
import java.lang.Character;

/*
 * Ch 1 - Strings and Arrays 
 * 1.1 - Implement an algorithm to determine if a string has all unique characters. 
 * What if you couldn't use additional data structures?
 */
public class OnePointOne {

	/*
	 * uniqueChars returns true if String input has unique chars, false otherwise
	 * - puts chars into a hashtable. if it has already been put into a hashtable, we know it's a duplicate
	 * runtime is O(n), where n is the number of chars in String input.
	 */
	public static boolean uniqueChars(String input) { 
		int len = input.length();
		Hashtable<Character, Integer> table = new Hashtable<>();
		
		for(int i = 0; i < len; i++) {
			if(table.containsKey(input.charAt(i))) {
				return false;
			}
			
			table.put(input.charAt(i), 1);
		}
		return true;
	}
	
	/*
	 * uniqueCharsNoDs returns true if String input has unique chars, false otherwise
	 * - creates a count array of 256 vales (representing all ascii values) that keep track of the times a char has been seen
	 * - in the input string. If a char has been seen before (it's count is 1 or more), we know it's a duplicate
	 * runtime is O(n), where n is the number of chars in String input.
	 */
	public static boolean uniqueCharsNoDs(String input) { 
		int len = input.length();
		if(len > 256) return false; // since only 256 ascii chars, if len > 256 string cannot be unique
		int[] count = new int[256]; //to optimize: make count a bool array instead of an int array 
		
		for(int i = 0; i < len; i++) {
			char curr_char = input.charAt(i);
			
			if(count[curr_char] == 1) //this means the char has been seen before (since count has been updated)
				return false;
			
			count[curr_char]++;	
		}
		return true;
	}
	
	public static void main(String[] args) { //testing the methods
		String t1 = "hey!!";
		System.out.println(t1 + " --> " + uniqueChars(t1));
		System.out.println(t1 + " --> " + uniqueCharsNoDs(t1)); //false
		System.out.println();
		
		String t2 = "hey";
		System.out.println(t2 + " --> " + uniqueChars(t2));
		System.out.println(t2 + " --> " + uniqueCharsNoDs(t2)); //true
		System.out.println();
		
		String t3 = "hi there! i'm richa.";
		System.out.println(t3 + " --> " + uniqueChars(t3));
		System.out.println(t3 + " --> " + uniqueCharsNoDs(t3)); //false
		System.out.println();
		
		String t5 = "1234567890/.,][;";
		System.out.println(t5 + " --> " + uniqueChars(t5));
		System.out.println(t5 + " --> " + uniqueCharsNoDs(t5)); //true 
		System.out.println();
	}

}