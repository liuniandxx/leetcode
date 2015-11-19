import javax.net.ssl.SSLContext;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by liunian on 15-10-19.
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        if(n < 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();

        while (n <= Integer.MAX_VALUE) {
            if(set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = getDigitSum(n);
            if(n == 1) {
                return true;
            }
        }
        return false;
    }

    public static int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
