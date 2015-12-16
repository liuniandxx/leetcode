/**
 * Created with IntelliJ IDEA.
 * User: liuniandxx
 * Date: 15-12-8
 * Time: 下午9:10
 * To change this template use File | Settings | File Templates.
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
	return isMatch(s, 0, p, 0);
    }

    public static boolean isMatch(String s, int ss, String p, int sp) {
        //当s, p都遍历完毕时，返回 true
	if (ss == s.length() && sp == p.length()) {
            return true;
        }
        if (sp == p.length()) {
            return false;
        }

        if (ss == s.length()) {
	    //注意这里的处理方式，当s遍历完毕时，p后面必须都是 .* 的形式成对出现
            if (sp + 1 >= p.length() || p.charAt(sp + 1) != '*') {
                return false;
            }
            return isMatch(s, ss, p, sp + 2);
        }


        if (sp + 1 < p.length() && p.charAt(sp + 1) == '*') {
            if (s.charAt(ss) == p.charAt(sp) || p.charAt(sp) == '.') {
                return isMatch(s, ss + 1, p, sp) || isMatch(s, ss, p, sp + 2);

            } else {
                return isMatch(s, ss, p, sp + 2);
            }
        } else if (p.charAt(sp) == '.') {
            return isMatch(s, ss + 1, p, sp + 1);
        } else {
            return s.charAt(ss) == p.charAt(sp) && isMatch(s, ss + 1, p, sp + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaba", "ab*a*c*a"));
    }
}
