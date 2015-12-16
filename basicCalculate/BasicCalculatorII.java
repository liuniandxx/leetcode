import sun.util.resources.cldr.ha.CalendarData_ha_Latn_GH;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: liuniandxx
 * Date: 15-12-9
 * Time: 下午1:35
 * To change this template use File | Settings | File Templates.
 */
public class BasicCalculatorII {
    public static int calculate(String s) {
        if(s == null || s.length() <= 0) {
            return 0;
        }
        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> opers = new Stack<Character>();
        int  i = 0;
        while (i < s.length()) {

            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <='9')) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numbers.push(num);

                if(!opers.isEmpty() && (opers.peek() == '/' || opers.peek() == '*')) {
                    int num2 = numbers.pop();
                    int num1 = numbers.pop();

                    if(opers.peek() == '*') {
                        int num3 = num1 * num2;
                        numbers.push(num3);
                        opers.pop();
                    }  else {
                        int num3 = num1 / num2;
                        numbers.push(num3);
                        opers.pop();
                    }
                }
            }

            if(i < s.length() &&(s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-')) {
                opers.push(s.charAt(i));
                i++;
            }

            if(i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
        }

        Stack<Integer> numStack = new Stack<Integer>();
        while (!numbers.isEmpty()) {
            numStack.push(numbers.pop());
        }

        Stack<Character> operStack = new Stack<Character>();
        while (!opers.isEmpty()) {
            operStack.push(opers.pop());
        }

        while (!operStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            if(operStack.peek() == '+') {
                int num3 = num1 + num2;
                numStack.push(num3);
                operStack.pop();
            } else {
                int num3 = num1 - num2;
                numStack.push(num3);
                operStack.pop();
            }
        }

        return numStack.peek();
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 - 1 + 1"));
    }
}
