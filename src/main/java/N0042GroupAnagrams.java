import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0042GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] tmp = new int[26];
            for (char c : strs[i].toCharArray()) {
                tmp[c - 97]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] != 0) {
                    sb.append('a' + j);
                    sb.append(tmp[j]);
                }
            }
            List<String> orDefault = map.getOrDefault(sb.toString(), new ArrayList<>());
            orDefault.add(strs[i]);
            map.put(sb.toString(), orDefault);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
