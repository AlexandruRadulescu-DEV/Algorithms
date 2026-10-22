package TwoPoitners;

//Given a string s, return true if the s can be palindrome after deleting at most one character from it.
//
//
//
//Example 1:
//
//Input: s = "aba"
//Output: true
//Example 2:
//
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
//Example 3:
//
//Input: s = "abc"
//Output: false
public class ValidPalindromII {

    static void main() {
        ValidPalindromII sol = new ValidPalindromII();
        Object[][] teste = {
                // { input, output așteptat }
//                {"aba", true},
//                {"abca", true},
//                {"abc", false},
//                {"a", true},
//                {"aa", true},
//                {"ab", true},
//                {"racecar", true},
//                {"raceacar", true},
//                {"abcba", true},
//                {"deeee", true},
//                {"eeeed", true},
//                {"aaaaab", true},
//                {"baaaaa", true},
//                {"abab", true},
//                {"abcda", false},
//                {"tebbem", false},
//                {"abcxyba", false},
//                {"eccer", true},
//                {"cbbcc", true},
//                {"abccdba", true},
                {"abcdcbea", true},
//                {"cupucu", true},
//                {"ucupuc", true},
        };

        int ok = 0;
        for (Object[] t : teste) {
            String s = (String) t[0];
            boolean asteptat = (boolean) t[1];
            boolean rezultat = sol.validPalindrome(s);
            boolean pass = rezultat == asteptat;
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  \"" + s + "\" -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }



    public boolean validPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;
        boolean removeLeft = false;
        boolean removeRight = false;
        int savedLeft = 0, savedRight = 0;

        while (left < right) {
            char characterLeft = s.charAt(left);
            char characterRight = s.charAt(right);

            if (characterLeft != characterRight) {
                if (!removeLeft) {
                    removeLeft = true;
                    savedLeft = left;
                    savedRight = right;
                    left++;
                    continue;
                } else if (!removeRight) {
                    removeRight = true;
                    left = savedLeft;
                    right = savedRight - 1;
                    continue;
                } else {
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }
    }
