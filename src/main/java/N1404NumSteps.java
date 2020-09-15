public class N1404NumSteps {

    public static int numSteps(String s) {
        int count = 0;
        int j = 0;
        int forHigh = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (forHigh == 0) {
                    count = j;
                    j += 2;
                    forHigh = 1;
                } else {
                    j++;
                    forHigh = 1;
                }
            } else {
                if (forHigh == 0) {
                    j++;
                    forHigh = 1;
                } else {
                    count = j;
                    j += 2;
                    forHigh = 1;
                }
            }
        }
        return forHigh == 0 ? count : j;
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
    }
}
