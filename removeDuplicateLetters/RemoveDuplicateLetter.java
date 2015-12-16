/**
 * Created by liuniandxx on 15-12-16.
 * 解题思路： 贪心策略，从开始字母r，且字母r是最小的r，且前面没有比他小的字母，也没有比r大，
 * 只出现一次的字母
 */
public class RemoveDuplicateLetter {
    public static String removeDuplicateLetters(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int[] cnt = new int[26];
        for(int i = 0; i < s.length();++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        int pos = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }

            if(--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replace("" + s.charAt(pos),""));



    }



    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
