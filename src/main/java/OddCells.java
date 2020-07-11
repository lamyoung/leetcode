import java.util.HashSet;
import java.util.Iterator;

public class OddCells {
	public int oddCells(int n, int m, int[][] indices) {
		HashSet<Integer> tmp = new HashSet<>();
		for (int i = 0; i < indices.length; i++) {
			int pos = n * indices[i][0] + indices[i][1];
			if(tmp.contains(pos)) {
				tmp.remove(pos);
			} else {
				tmp.add(pos);
			}
		}
		int count = 0;
		Iterator<Integer> iterator=tmp.iterator();
		while(iterator.hasNext()) {
			if(iterator.next()>0) {
				count++;
			}
		}
		return count;
	}
}
