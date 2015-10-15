/**
 * Created by liunian on 15-10-15.
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        }

        if(s == null || t == null) {
            return false;
        }

        int lens = s.length();
        int lent = t.length();

        if(lens != lent) {
            return false;
        }

        int[] cnts = new int[26];
        int[] cntt = new int[26];

        for(int i = 0; i < lens; i++) {
            cnts[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < lent; i++) {
            cntt[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26;i++) {
            if(cnts[i] != cntt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
