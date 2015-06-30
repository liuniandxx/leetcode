
/**
 * 
 * @author liunian 
 * 2015/06/30
 * 
 * 厄拉多塞筛法
 */
public class CountPrimes {
	public int countPrimes(int n) {
		boolean[] isNoPrimes = new boolean[n];
		int sqrt = (int) Math.round(Math.sqrt(n));
		for(int i = 2; i <= sqrt; i++) {
			if(!isNoPrimes[i]) {
				for(int j = i + i; j < n;j += i) {
					isNoPrimes[j] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(!isNoPrimes[i]) {
				count++;
			}
		}
		return count;
    }
}
