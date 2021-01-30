public class N1232CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int initX = coordinates[0][0], initY = coordinates[0][1];
        if (coordinates[1][0] == initX) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != initX) {
                    return false;
                }
            }
            return true;
        }
        double k = (double) (coordinates[1][1] - initY) / (coordinates[1][0] - initX);
        for (int i = 2; i < coordinates.length; i++) {
            if (coordinates[i][0] == initX) {
                return false;
            }
            if (k != (double) (coordinates[i][1] - initY) / (coordinates[i][0] - initX)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N1232CheckStraightLine c = new N1232CheckStraightLine();
        int[][] coor = new int[][]{{1, 1}, {2, 2}, {2, 0}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(c.checkStraightLine(coor));
    }
}
