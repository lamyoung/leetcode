import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class N1656_1OrderedStream {

    private PriorityQueue<Pair<Integer, String>> queue;
    private int ptr = 1;

    public N1656_1OrderedStream(int n) {
        this.queue = new PriorityQueue<Pair<Integer, String>>(n, new Comparator() {
            public int compare(Object o1, Object o2) {
                Pair<Integer, String> obj1 = (Pair<Integer, String>) o1;
                Pair<Integer, String> obj2 = (Pair<Integer, String>) o2;
                if (obj1.getKey() > obj2.getKey())
                    return 1;
                else if (obj1.getKey() < obj2.getKey())
                    return -1;
                else
                    return 0;
            }

        });

    }

    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList<>();
        if (id != ptr) {
            queue.add(new Pair<>(id, value));
        } else {
            res.add(value);
            while (!queue.isEmpty() && queue.peek().getKey() - 1 == ptr) {
                Pair<Integer, String> tmp = queue.poll();
                res.add(tmp.getValue());
                ptr++;
            }
            ptr++;
        }
        return res;
    }

    public static void main(String[] args) {
        N1656_1OrderedStream obj = new N1656_1OrderedStream(5);
        List<String> res1 = obj.insert(3, "ccccc");
        System.out.println(res1);
        List<String> res2 = obj.insert(1, "aaaaa");
        System.out.println(res2);
        List<String> res3 = obj.insert(2, "bbbbb");
        System.out.println(res3);
        List<String> res4 = obj.insert(5, "eeeee");
        System.out.println(res4);
        List<String> res5 = obj.insert(4, "ddddd");
        System.out.println(res5);
    }
}
