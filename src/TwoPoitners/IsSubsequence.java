package TwoPoitners;

public class IsSubsequence {
//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//
//
//
//Example 1:
//
//Input: s = "abc", t = "ahbgdc"
//Output: true
//Example 2:
//
//Input: s = "axc", t = "ahbgdc"
//Output: false

    static void main() {
        IsSubsequence sol = new IsSubsequence();
        Object[][] teste = {
                // { s, t, output așteptat }
                {"abc", "ahbgdc", true},
//                {"axc", "ahbgdc", false},
//                {"", "ahbgdc", true},
//                {"", "", true},
//                {"a", "", false},
//                {"a", "a", true},
//                {"a", "b", false},
//                {"abc", "abc", true},
//                {"abc", "ab", false},
//                {"ace", "abcde", true},
//                {"aec", "abcde", false},
//                {"cba", "abc", false},
//                {"aa", "a", false},
//                {"aa", "aba", true},
//                {"aaa", "aab", false},
//                {"b", "abc", true},
//                {"c", "abc", true},
//                {"abc", "xxaxxbxxcxx", true},
//                {"leetcode", "yyleetcodeyy", true},
//                {"bb", "ahbgdc", false},
        };

        int ok = 0;
        for (Object[] t : teste) {
            String s = (String) t[0];
            String text = (String) t[1];
            boolean asteptat = (boolean) t[2];
            String input = "s=\"" + s + "\", t=\"" + text + "\"";

            String rezultat;
            boolean pass;
            try {
                boolean r = sol.isSubsequence(s, text);
                rezultat = String.valueOf(r);
                pass = r == asteptat;
            } catch (Exception e) {
                // o excepție (ex. index în afara string-ului) contează ca FAIL, nu oprește restul testelor
                rezultat = e.getClass().getSimpleName();
                pass = false;
            }
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  " + input + " -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }


    public boolean isSubsequence(String s, String t) {

        int left = 0;
        int k = 0;
        for (int i = 0; i < t.length(); i++) {

            if (left < s.length()) {
                if (s.charAt(left) == t.charAt(i)) {
                    k++;
                    left++;
                }
            }
        }
        return k == s.length();
    }
}
