import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

public class N0217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int cur : nums) {
            if(set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
            }
        }
        return false;
    }
}
