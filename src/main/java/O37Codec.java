import java.util.Stack;

public class O37Codec {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder res = new StringBuilder("[");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            if (root == null) {
                res.append("null,");
            } else {
                res.append(root.val).append(",");
                stack.push(root.right);
                stack.push(root.left);
            }
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Encodes a tree to a single string.
    public static String serialize2(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder res = new StringBuilder("[");
        dfs(res, root);
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    private static void dfs(StringBuilder res, TreeNode root) {
        if (root == null) {
            res.append("null,");
            return;
        } else {
            res.append(root.val).append(",");
        }
        dfs(res, root.left);
        dfs(res, root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        TreeNode res = root;
        boolean flag = false;
        for (int i = 1; i < split.length; i++) {
            if (split[i].equals("null")) {
                if (flag) {
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        root = stack.pop();
                    }
                } else {
                    flag = true;
                }
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                if (flag) {
                    root.right = node;
                    root = node;
                    flag = false;
                } else {
                    root.left = node;
                    stack.push(root);
                    root = node;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "[1,2,null,null,3,4,null,null,5,null,null]";
        TreeNode res = deserialize(test);
        String res2 = serialize(res);
        System.out.println(res2);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

