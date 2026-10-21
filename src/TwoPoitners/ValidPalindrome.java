package TwoPoitners;

import java.util.Locale;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
public class ValidPalindrome {

    static void main() {
        ValidPalindrome vp = new ValidPalindrome();

        String[] inputs = {
                "A man, a plan, a canal: Panama", // true
                "race a car",                     // false
                " ",                              // true
                "",                               // true
                "a",                              // true
                "aa",                             // true
                "ab",                             // false
                ".,",                             // true
                "0P",                             // false
                "Was it a car or a cat I saw?",   // true
                "No 'x' in Nixon",                // true
                "12321",                          // true
                "123abccba321",                   // true
                "1a2",                            // false
                ".a",                             // true
                "a.",                             // true
                "ab_a",                           // true
                "Madam, I'm Adam",                // true
                "abcd",                           // false
                "Aa",                             // true
        };
        boolean[] expected = {
                true, false, true, true, true, true, false, true, false, true,
                true, true, true, false, true, true, true, true, false, true
        };

        for (int i = 0; i < inputs.length; i++) {
            boolean result = vp.isPalindrome(inputs[i]);
            System.out.println("\"" + inputs[i] + "\" -> expected: " + expected[i] + ", got: " + result);
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char character = s.charAt(left);

            if (!Character.isLetterOrDigit(character)) {
                left++;
                continue;
            }
            char charterRight = s.charAt(right);
            if (!Character.isLetterOrDigit(charterRight)) {
                right--;
                continue;

            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;

        }
        return true;
    }
}

