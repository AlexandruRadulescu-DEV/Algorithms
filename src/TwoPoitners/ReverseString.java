package TwoPoitners;
//Write a function that reverses a string. The input string is given as an array of characters s.
//
//You must do this by modifying the input array in-place with O(1) extra memory.
//
//
//
//Example 1:
//
//Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
//Example 2:
//
//Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
public class ReverseString {

    static void main() {
        ReverseString sol = new ReverseString();
        String[][] teste = {
                // { input, output așteptat }
                {"hello", "olleh"},
                {"Hannah", "hannaH"},
                {"a", "a"},
                {"", ""},
                {"ab", "ba"},
                {"abc", "cba"},
                {"abcd", "dcba"},
                {"abcde", "edcba"},
                {"aaaa", "aaaa"},
                {"racecar", "racecar"},
                {"abba", "abba"},
                {"abca", "acba"},
                {"baaaa", "aaaab"},
                {"aaaab", "baaaa"},
                {"   ", "   "},
                {" ab ", " ba "},
                {"0123456789", "9876543210"},
                {"aAbBcC", "CcBbAa"},
                {"1 !Az", "zA! 1"},
                {"!@#$%^&*()", ")(*&^%$#@!"},
                {"ăâîșț", "țșîâă"},
                {"two pointers", "sretniop owt"},
        };

        int ok = 0;
        for (String[] t : teste) {
            char[] s = t[0].toCharArray();
            sol.reverseString(s);
            String rezultat = new String(s);
            boolean pass = rezultat.equals(t[1]);
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  \"" + t[0] + "\" -> \"" + rezultat
                    + "\"" + (pass ? "" : "  (așteptat \"" + t[1] + "\")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }


    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length-1;

        while(left<right){
            char tempLeft = s[left];
            s[left] = s[right];
            s[right] = tempLeft;
            left++;
            right--;
        }

    }

}
