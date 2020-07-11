import java.util.HashSet;

/**
 * @author lam young
 * @Description
 * @create 2020/6/21 9:29
 */
public class SingleNumber {

	public static void main(String[] args) {

	}

	public static int singleNumber(int[] nums) {
		HashSet<Integer> map = new HashSet<>(nums.length);
		for(int num: nums) {
			if(map.contains(num)) {
				map.remove(num);
			} else {
				map.add(num);
			}
		}
		return map.iterator().next();
	}

	public static int singleNumber2(int[] nums) {
		int res = 0;
		for(int num: nums) {
			res ^= num;
		}
		return res;
	}
}
