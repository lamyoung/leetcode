public class N0011MaxArea {

    public int maxArea(int[] height) {
        int pre = 0, last = height.length - 1;
        int max = Math.min(height[pre], height[last]) * last;
        while (pre < last) {
            if (height[pre] < height[last]) {
                int cur = pre;
                while (height[cur] <= height[pre] && cur < last) {
                    cur++;
                }
                if (cur < last) {
                    max = Math.max(max, Math.min(height[cur], height[last]) * (last - cur));
                }
                pre = cur;
            } else {
                int cur = last;
                while (height[cur] <= height[last] && cur > pre) {
                    cur--;
                }
                if (cur > pre) {
                    max = Math.max(max, Math.min(height[pre], height[cur]) * (cur - pre));
                }
                last = cur;
            }
        }
        return max;
    }
}
