import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liunian on 15-10-8.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        //pattern str 两个只有一个为空， 返回 false
        if(pattern == null && str != null) {
            return false;
        }

        if(pattern != null && str == null) {
            return false;
        }


        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            String value = map.get(ch);
            if(value == null && !set.contains(strs[i])) {
                map.put(ch, strs[i]);
                set.add(strs[i]);
            } else if(value != null && value.equals(strs[i])) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
