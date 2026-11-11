package TwoPoitners;
//Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
//
//Note that after backspacing an empty text, the text will continue empty.
//
//
//
//Example 1:
//
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
//Example 2:
//
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
//Example 3:
//
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".
public class BackspaceStringCompare {

    static void main() {
        BackspaceStringCompare sol = new BackspaceStringCompare();
        Object[][] teste = {
                // { s, t, output așteptat }
                {"ab#c", "ad#c", true},
                {"ab##", "c#d#", true},
                {"a#c", "b", false},
                {"a", "a", true},
                {"a", "b", false},
                {"#", "", true},
                {"###", "#", true},
                {"a##", "#", true},
                {"a#", "", true},
                {"abc", "abc", true},
                {"abc", "abd", false},
                {"ab#", "a", true},
                {"a##c", "#a#c", true},
                {"bxj##tw", "bxo#j##tw", true},
                {"bxj##tw", "bxj###tw", false},
                {"xywrrmp", "xywrrmu#p", true},
                {"nzp#o#g", "b#nzp#o#g", true},
                {"bbbextm", "bbb#extm", false},
                {"abc#d", "abzz##d", true},
                {"y#fo##f", "y#f#o##f", true},
                {"a#b#c#", "", true},
                {"ab", "b", false},
                {"#a", "a", true},
                {"aaa###a", "aaaa###a", false},
        };

        int ok = 0;
        for (Object[] t : teste) {
            String s = (String) t[0];
            String tt = (String) t[1];
            boolean asteptat = (boolean) t[2];

            boolean rezultat = sol.backspaceCompare(s, tt);
            boolean pass = rezultat == asteptat;
            if (pass) ok++;
            System.out.println((pass ? "PASS" : "FAIL") + "  s=\"" + s + "\", t=\"" + tt + "\" -> " + rezultat
                    + (pass ? "" : "  (așteptat " + asteptat + ")"));
        }
        System.out.println("\n" + ok + "/" + teste.length + " teste trecute");
    }


    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String str) {
        StringBuilder sb = new StringBuilder();
        int skip = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
