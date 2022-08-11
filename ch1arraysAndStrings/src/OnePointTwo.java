public class OnePointTwo {
    // ex. listen and silent are permutations
    public static boolean isPermutation(String str1, String str2) {
        if(str1.length() != str2.length()) { // if they are different lengths, they cannot be permutations
            return false;
        }

        int[] count = new int[128]; // assuming ASCII, would be 256 with extended ASCII

        /*
         * other ideas: 1) sort and then compare, but sorting is O(n log n) minumum
         * 
         * this idea seems to have the best time complexity: O(n) linear runtime overall. More specifically O(s) + O(128) where s is
         * the length of the strings (at this point we know they're the same length) and the 128/constant part for the second for loop
         */

        for(int i = 0; i < str1.length(); i++) {
            count[Character.toLowerCase(str1.charAt(i))]++;
            count[Character.toLowerCase(str2.charAt(i))]--;
        }

        for(int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Listen and Silent are permuatations: " + isPermutation("Listen", "Silent"));
        System.out.println("Bad Credit and Debit Card are permuatations: " + isPermutation("Bad Credit", "Debit Card"));
        System.out.println("Hello and Goodbye are permuatations: " + isPermutation("Hello", "Goodbye"));
        System.out.println("Hellooo and Goodbye are permuatations: " + isPermutation("Hellooo", "Goodbye"));
        System.out.println("Richa and chair are permuatations: " + isPermutation("Richa", "chair"));
    } 
}

/*
 * notes from the book: 
 * - it's good to ask clarifications: does whitespace count? is it case sensitive? are we assuming the strings are ASCII or unicode?
 * - for sorting you could use Arrays.sort, although runtime is longer it is quite a bit cleaner + more intuitive
 */