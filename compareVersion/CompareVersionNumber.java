/**
 * Created by liunian on 15-10-15.
 */
public class CompareVersionNumber {

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;
        while (i < arr1.length || i < arr2.length) {
            if(i < arr1.length && i < arr2.length) {
                int val1 = Integer.parseInt(arr1[i]);
                int val2 = Integer.parseInt(arr2[i]);

                if(val1 > val2) {
                    return 1;
                } else if(val1 < val2) {
                    return -1;
                }
            } else if(i < arr1.length) {
                if(Integer.parseInt(arr1[i]) != 0) {
                    return 1;
                }
            } else {
                if(Integer.parseInt(arr2[i]) != 0) {
                    return -1;
                }
            }
            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "1"));
    }

}
