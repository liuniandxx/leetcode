
/**
 * 
 * @author liunian
 * 2015/07/06
 * 判断n是否为2的power
 * 
 * n <= 0
 * 肯定不为2的power
 * 
 * 加入 n为2的power
 * n的二进制表示为 10...0 （n = 2^k, 1后面有k个0）
 * 那么 n - 1 的二进制表示为(1..11（k个1）)
 * 
 * 那么 (n & (n - 1)) = 0 
 *
 */
public class IsPowerOfTwo {
	
	public boolean isPowerOfTwo(int n) {
		if(n <= 0) {
			return false;
		}
		
		return (n & (n - 1)) == 0;
	}
}
