import java.util.Stack;

/**
 * @author liunian
 * 2015/07/01
 *
 * 最长匹配括号子串
 *
 * 举例：
 * 字符串 只包含 '(' 和 ')'
 * 求匹配的最长子串
 *
 *  假如字符串为 " ()(((())  "
 *  那么 最长的匹配子串为: (())
 *  最大长度为： 4
 *
 *  思路：
 *  使用stack，标志数组flag(boolean，初始为false)，从字符串的第一个字符开始遍历子串
 *  1. 当字符为'('时，将字符的索引压入stack
 *  2. 当字符为')'时，判断当前stack是否为空，如果为空不做任何操作，接着遍历下一个字符，
 *     如果stack不为空，获取stack的栈顶值,同时进行一次弹栈操作,同时将flag当前索引和栈顶索引设置为true
 *
 *  最后，统计flag数组中最长连续true值即可
 *
 *
 *  原理：由于利用了栈操作，当前字符和栈顶字符（stack不为空的情况下）之间的缺省串是匹配的
 *
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        boolean[] flag  = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if(tmp == '(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty())  {
                    int top = stack.peek();
                    flag[top] = true;
                    flag[i] = true;
                    stack.pop();
                }
            }
        }
        int maxLen = 0;
        int curLen = 0;
        for(int i = 0; i < s.length(); i++) {
            if(flag[i]) {
                curLen++;
                maxLen = Math.max(curLen, maxLen);
            } else {
                curLen = 0;
            }
        }
        return maxLen;
    }
}
