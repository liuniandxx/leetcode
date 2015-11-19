import java.util.*;

/**
 * Created by liunian on 15-10-20.
 * hashmap + 字符串内部排序 + 字符串间排序
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();

        if(strs == null) {
            return lists;
        }

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length;i++) {
            String sortStr = sortString(strs[i]);
            List<String> list = map.get(sortStr);
            if(null == list) {
                list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(sortStr, list);
            } else {
                list.add(strs[i]);
            }
        }

        lists.addAll(map.values());
        for(List<String> elems : lists) {
            Collections.sort(elems);
        }
        return lists;
    }

    public static String sortString(String str) {
        //字符串 和 字符数组之间的转化 string.toCharArray() String(charArray) 
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = groupAnagrams(strs);

        for(List<String> elems : lists) {
            for(String tmp : elems) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
    }
}
