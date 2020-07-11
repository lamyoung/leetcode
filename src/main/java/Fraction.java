public class Fraction {

	public int[] fraction(int[] cont) {
		int length = cont.length;
		int[] up = new int[length];
		int[] down = new int[length];
		up[length - 1] = cont[length - 1];
		down[length - 1] = 1;
		for (int i = length - 2; i >= 0; i--) {
			up[i] = cont[i]*up[i + 1] + down[i + 1];
			down[i] = up[i + 1];
		}
		return new int[]{up[0], down[0]};
	}
}
