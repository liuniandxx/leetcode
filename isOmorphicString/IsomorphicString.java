import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liunian on 15-11-2.
 * 思路： 使用hashmap 建立 字符之间的对应关系
 * 需要注意字符出现的顺序和加入到hashmap之间的对应关系
 */
public class IsomorphicString {
    public static boolean helpIsIsomorphic(String s, String t) {
        if((s == null && t != null) || (s != null && t == null)) {
            return false;
        }

        if((s == null && t == null) ||(s.length() == 0 && t.length() == 0)) {
            return true;
        }

        if(s.length() != t.length()) {
            return false;
        }

        int len = s.length();
        int index = 0;
        Map<Character, Character> map = new HashMap<Character, Character>();

        while (index < len) {
            Character sIndex = s.charAt(index);
            Character tIndex = t.charAt(index);
            Character val = map.get(sIndex);
            if(val == null) {
                map.put(sIndex, tIndex);
            } else if(val.equals(tIndex)) {
                ;
            } else {
                return false;
            }
            index++;
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {
        return helpIsIsomorphic(s, t) && helpIsIsomorphic(t, s);
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("", ""));
    }
}
