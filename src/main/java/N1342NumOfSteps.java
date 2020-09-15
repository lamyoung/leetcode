public class N1342NumOfSteps {

    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 0) {
            if(num==1) {
                return res++;
            }
            if ((num & 1) == 1) {
                res += 2;
            } else {
                res++;
            }
            num = num >> 1;
        }
        return res;
    }
}
