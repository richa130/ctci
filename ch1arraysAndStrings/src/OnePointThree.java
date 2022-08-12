/*
 * Write a method to replace all spaces in a string with "%20". Assume that the given string has suffient
 * whitespace at the end (no resizing necessary) and that you are given the "true" length of the string (w/out
 * the whitespace)
 */

public class OnePointThree {
    public static String URLify(String input, int length) {
        char[] url = input.toCharArray();
        int spacesAtEnd = url.length - length;

        /*
         * another solution would be to brute force it, every time you encouter a space have another loop and
         * just move everything over again by two, but that is inefficient and has a large runtime
         * 
         * the runtime of my way is linear O(n), where n is the "true" length of the string 
         * - a little more about my logic: the spaces at the end will always be a multiple of 2 (we want to
         * replace each space ' ' (1 char) with '%20' (3 chars), so the extra space needed for one space is
         * 2 chars). we can shift everything over by the amount of spaces at the end, and everytime we encounter
         * a space and replace is with '%20', we subtract 2 from the amount we shift it over (because we have 
         * taken up 2 from the whitespace at the end) 
         */
        for(int i = length - 1; i > 0; i--) {
            if(url[i] == ' ') {
                url[i + spacesAtEnd] = '0';
                url[i + spacesAtEnd - 1] = '2';
                url[i + spacesAtEnd - 2] = '%';

                spacesAtEnd -= 2;

                continue;
            }

            url[i+spacesAtEnd] = url[i];
        }

        return new String(url);
    }
    
    public static void main(String[] args) {
        System.out.println(URLify("hi omg wow yo      ", 13));
        System.out.println(URLify("mr john smith    ", 13));
        System.out.println(URLify("hello world  ", 11));
    }
}

/*
 * notes from the book: 
 * - a common approach for string manipulation problems is to start from the end and work backwards
 * 
 */