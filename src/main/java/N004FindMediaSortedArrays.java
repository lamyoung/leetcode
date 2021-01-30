public class N004FindMediaSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int i = -1;
        int j = -1;
        int pre = 0;
        int next = 0;
        int count = 0;
        while (count < length / 2 + 1 && i < nums1.length - 1 && j < nums2.length - 1) {
            pre = next;
            if (nums1[i + 1] < nums2[j + 1]) {
                count++;
                i++;
                next = nums1[i];
            } else {
                count++;
                j++;
                next = nums2[j];
            }
        }
        if (count < length / 2 + 1) {
            if (i < nums1.length - 1) {
                while (count < length / 2 + 1) {
                    count++;
                    i++;
                    pre = next;
                    next = nums1[i];
                }
            } else {
                while (count < length / 2 + 1) {
                    count++;
                    j++;
                    pre = next;
                    next = nums2[j];
                }
            }
        }
        if ((length & 1) == 1) {
            return next;
        } else {
            return ((double)pre + (double)next) / 2;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        findMedianSortedArrays(a,b);
    }
}
