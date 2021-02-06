import java.util.*;

public class N0127LadderLength {

    public static void main(String[] args) {
        N0127LadderLength l = new N0127LadderLength();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(l.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 1) {
            for(String word:wordList) {
                if(endWord.equals(word)) {
                    return 2;
                }
            }
            return 0;
        }
        if(beginWord.equals(endWord)) {
            return 2;
        }
        boolean flag = false;
        Node root = new Node(beginWord);
        HashMap<String, List<Node>> map = new HashMap<>();
        wordList.add(beginWord);
        for (String str : wordList) {
            if (!flag && str.equals(endWord)) {
                flag = true;
            }
            Node node = new Node(str);
            if (str.equals(beginWord)) {
                root = node;
            }
            for (String cur : getChildStr(str)) {
                List<Node> curList = map.getOrDefault(cur, new ArrayList<>());
                for (Node curNode : curList) {
                    curNode.addConn(node);
                    node.addConn(curNode);
                }
                curList.add(node);
                map.put(cur, curList);
            }
        }
        if (!flag) {
            return 0;
        }
        int[] res = new int[]{Integer.MAX_VALUE};
        HashSet<Node> set = new HashSet<>();
        dfs(res, 1, set, root, endWord);
        return res[0] > 0 ? res[0] : 0;
    }

    private void dfs(int[] res, int curLevel, HashSet<Node> set, Node node, String endWord) {
        if (set.contains(node)) {
            return;
        }
        if (node.word.equals(endWord)) {
            res[0] = Math.min(res[0], curLevel);
            return;
        }
        set.add(node);
        for (Node cur : node.conn) {
            dfs(res, curLevel + 1, set, cur, endWord);
        }
        set.remove(node);
    }

    private List<String> getChildStr(String str) {
        List<String> res = new ArrayList<>();
        res.add(new StringBuilder()
                .append("*")
                .append(str.substring(1))
                .toString());
        for (int i = 1; i < str.length(); i++) {
            res.add(new StringBuilder()
                    .append(str, 0, i)
                    .append("*")
                    .append(str.substring(i + 1))
                    .toString());
        }
        return res;
    }

    private class Node {
        String word;
        HashSet<Node> conn;

        public Node(String word) {
            this.word = word;
            conn = new HashSet<>();
        }

        public void addConn(Node node) {
            conn.add(node);
        }
    }
}
