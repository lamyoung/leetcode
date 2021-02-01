public class N0605CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int start = -1;
        int i = 0;
        while (i < flowerbed.length && n > 0) {
            if (flowerbed[i] == 0) {
                i++;
                continue;
            }
            if (start < 0) {
                n -= i / 2;
            } else {
                n -= (i - start - 2) / 2;
            }
            start = i;
            i++;
        }
        if (start < 0) {
            n -= (flowerbed.length + 1) / 2;
        } else {
            n -= (flowerbed.length - start - 1) / 2;
        }
        return n <= 0;
    }
}
