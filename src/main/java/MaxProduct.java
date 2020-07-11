import java.util.Stack;

public class MaxProduct {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(5);
		TreeNode right  = new TreeNode(6);
		TreeNode root1 = new TreeNode(4);
		root1.left = left;
		root1.right = right;
		left = new TreeNode(3);
		TreeNode root2 = new TreeNode(2);
		root2.left = left;
		root2.right = root1;
		TreeNode root = new TreeNode(1);
		root.right = root2;
		System.out.println(maxProduct(root));
	}
	public static int maxProduct(TreeNode root) {
		long allSum = sum(root);
		long maxMin = maxMin(root, allSum);
		return (int)(maxMin%1000000007) * (int)((allSum - maxMin)%1000000007);
	}

	public static long maxMin(TreeNode root, long allSum) {
		if(root== null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		long maxMin = allSum;
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (tmp.right != null) {
				stack.push(tmp.right);
			}
			if (tmp.left != null) {
				stack.push(tmp.left);
			}
			long tmpSum = sum(tmp);
			tmpSum = Math.min(tmpSum, allSum-tmpSum);
			if(maxMin>allSum/2) {
				maxMin = tmpSum;
			} else {
				maxMin = Math.max(maxMin, tmpSum);
			}
		}
		return maxMin;
	}

	public static long sum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		long sum = 0;
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			sum += tmp.val;
			if (tmp.right != null) {
				stack.push(tmp.right);
			}
			if (tmp.left != null) {
				stack.push(tmp.left);
			}
		}
		return sum;
	}

	private static class TreeNode {
		long val;
		TreeNode left;
		TreeNode right;

		TreeNode(long x) {
			val = x;
		}
	}
}


