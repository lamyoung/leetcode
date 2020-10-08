public class O33VerifyPostOrder {

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return true;
        }
        return isPostorder(postorder, 0, postorder.length - 1);
    }

    public static boolean isPostorder(int[] postorder, int start, int end) {
        if (start == end || end - start == 1 || start > end) {
            return true;
        }
        int nextEnd = 0;
        int i = start;
        while (postorder[i] < postorder[end]) i++;
        int m = i - 1;
        while (postorder[i] > postorder[end]) i++;
        return i == end && isPostorder(postorder, start, m) && isPostorder(postorder, m + 1, end - 1);
    }

    public static boolean verifyPostorder2(int[] postorder) {
        if (postorder == null || postorder.length == 1 || postorder.length == 2) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < postorder.length - 1; i++) {
            if (postorder[i] > postorder[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }
}
