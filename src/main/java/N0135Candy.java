public class N0135Candy {

    public int candy(int[] ratings) {
        int min = 1;
        int sum = 1;
        int curr = 1;
        int count = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                curr++;
                sum += curr;
                count++;
                continue;
            }
            if (ratings[i] < ratings[i - 1]) {
                curr--;
                min = Math.min(min, curr);
                sum += curr;
                count++;
                continue;
            }
            if (ratings[i] == ratings[i - 1]) {
                if (min < 1) {
                    sum += (1 - min) * count;
                }
                min = 1;
                curr = 1;
                count = 1;
                sum += curr;
            }
        }
        if (min < 1) {
            sum += (1 - min) * count;
        }
        return sum;
    }

    public static void main(String[] args) {
        N0135Candy c = new N0135Candy();
        int[] candy = new int[]{1, 3,4,5,2};
        System.out.println(c.candy(candy));
    }
}
