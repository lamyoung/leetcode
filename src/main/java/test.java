import java.util.Stack;

public class test {

	public static void main(String[] args) {
//		LargestPerimeter tool = new LargestPerimeter();
//		int[] e = new int[] { 3, 2, 3, 4 };
//		int res = tool.largestPerimeter(e);
//		System.out.println(res);

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(p);
		stack.push(q);
		while(!stack.isEmpty()) {
			q = stack.pop();
			p = stack.pop();
			if(p==null && q==null) {
				continue;
			}
			if(p==null || q==null) {
				return false;
			}
			if(p.val != q.val) {
				return false;
			}
			stack.push(p.left);
			stack.push(q.left);
			stack.push(p.right);
			stack.push(q.right);
		}
		return true;
	}

	public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

}
