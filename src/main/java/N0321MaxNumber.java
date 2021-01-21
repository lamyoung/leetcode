//import javafx.util.Pair;
//
//import java.util.PriorityQueue;
//import java.util.Stack;
//
//public class N0321MaxNumber {
//
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        Stack<Integer> stack1 = new Stack<>();
//        for (int i = 0; i < nums1.length; i++) {
//            while (!stack1.isEmpty() && nums1[i] > stack1.peek() && stack1.size() - 1 + nums1.length - i >= k) {
//                stack1.pop();
//            }
//            if (stack1.size() < k) {
//                stack1.push(nums1[i]);
//            }
//        }
//        int[] res1 = new int[k];
//        for (int i = k - 1; i >= 0; i--) {
//            res1[i] = stack1.pop();
//        }
//        Stack<Integer> stack2 = new Stack<>();
//        for (int i = 0; i < nums2.length; i++) {
//            while (!stack2.isEmpty() && nums2[i] > stack2.peek() && stack2.size() - 1 + nums2.length - i >= k) {
//                stack2.pop();
//            }
//            if (stack2.size() < k) {
//                stack2.push(nums1[i]);
//            }
//        }
//        int[] res2 = new int[k];
//        for (int i = k - 1; i >= 0; i--) {
//            res2[i] = stack2.pop();
//        }
//    }
//}
