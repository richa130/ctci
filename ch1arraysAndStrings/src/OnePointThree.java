/*
 * Write a method to replace all spaces in a string with "%20". Assume that the given string has suffient
 * whitespace at the end (no resizing necessary) and that you are given the "true" length of the string (w/out
 * the whitespace)
 */

public class OnePointThree {
    public static String URLify(String input, int length) {
        int spacesAtEnd = input.length() - length;

        char[] url = input.toCharArray();

        for(int i = length - 1; i > 0; i--) {
            if(url[i] == ' ') {
                url[i + spacesAtEnd] = '0';
                url[i + spacesAtEnd - 1] = '2';
                url[i + spacesAtEnd - 2] = '%';

                spacesAtEnd -= 2;
            }

            url[i+spacesAtEnd] = url[i];
        }

        return new String(url);
    }
    
    public static void main(String[] args) {
        System.out.println(URLify("mr john smith    ", 13));
    }
}

/*
 * will fix tomorrow - having bug where all spaces except last one are including the 20 but not the %
 */