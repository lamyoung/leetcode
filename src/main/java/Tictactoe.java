public class Tictactoe {

	public String tictactoe(int[][] moves) {
		int[] wins = { 7, 56, 448, 73, 146, 292, 273, 84 };
		int a = 0, b = 0;
		for (int i = 0; i < moves.length; i++) {
			if ((i & 1) == 1) {
				b |= 1 << (3 * moves[i][0] + moves[i][1]);
			} else {
				a |= 1 << (3 * moves[i][0] + moves[i][1]);
			}
		}
		for (int win : wins) {
			if ((win & a)==win) {
				return "A";
			}
			if ((win & b) == win) {
				return "B";
			}
		}
		return moves.length == 9 ? "Draw" : "Pending";
	}
}
