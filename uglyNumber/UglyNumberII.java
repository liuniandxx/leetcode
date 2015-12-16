import java.util.ArrayList;
import java.util.List;

/**
 * Created by liunian on 15-10-19.
 */
public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<Integer>();

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        list.add(1);

        while (list.size() < n) {
            int tmp2 = list.get(index2) * 2;
            int tmp3 = list.get(index3) * 3;
            int tmp5 = list.get(index5) * 5;

            int minix = Math.min(tmp2, Math.min(tmp3, tmp5));

            if(minix == tmp2) {
                index2++;
            }

            if(minix == tmp3) {
                index3++;
            }

            if(minix == tmp5) {
                index5++;
            }
            list.add(minix);
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(2));
    }
}