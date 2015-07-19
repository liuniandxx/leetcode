

/**
 * 
 * @author liunian
 * 2015/07/19
 * 主要思想：
 * 康托编码
 *
 */
public class Permutation {

	public String permutation(int n, int k) {
		int[] dataPermutation = new int[10];
		dataPermutation[0] = 1;
		for(int i = 1; i < 10; i++) {
			dataPermutation[i] = i * dataPermutation[i - 1];
		}
		
		int[] flag = new int[10];
		
		String res = "";
		int i = 1;
		k--;
		while(i <= n) {
			int nextPos = k / dataPermutation[n - i];
			int j = 0;
			for(j = 1; j <= n;j++) {
				if(flag[j] == 0) {
					nextPos--;
				} 
				if(nextPos < 0) {
					break;
				}
			}
			k %=dataPermutation[n - i];
			i++;
			res += (char)(j + '0');
			flag[j] = 1;
		}
		return res;
	}
}
