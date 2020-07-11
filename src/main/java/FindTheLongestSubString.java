import java.util.HashMap;

/**
 * @author lam young
 * @Description
 * @create 2020/5/20 23:11
 */
public class FindTheLongestSubString {

	public static int findTheLongestSubstring(String s) {
		HashMap<Integer,Integer> stateMap = new HashMap<Integer, Integer>();
		int res = 0;
		int max = 0;
		stateMap.putIfAbsent(0, -1);
		for(int i = 0;i<s.length();i++){
			res = cal(res, s.charAt(i));
			if (stateMap.containsKey(res)) {
				max = Math.max(max,i-stateMap.get(res));
			}
			stateMap.putIfAbsent(res,i);
		}
		return max;
	}

	public static int cal(int res, char c) {
		switch(c) {
			case 'a':res ^= (1 << 4); break;
			case 'e':res ^= (1 << 3); break;
			case 'i':res ^= (1 << 2); break;
			case 'o':res ^= (1 << 1); break;
			case 'u':res ^= 1; break;
			default:break;
		}
		return res;
	}
}
