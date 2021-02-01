import java.util.*;

class N1656_2OrderedStream {

    private String[] arr;
    private int ptr = 1;

    public N1656_2OrderedStream(int n) {
        this.arr = new String[2];
    }

    public List<String> insert(int id, String value) {
        List<String> res = new ArrayList<>();
        if (id != ptr) {
            if (id >= arr.length) {
                this.arr = Arrays.copyOf(arr, Math.max(id + 100, arr.length * 2));
            }
            arr[id] = value;
        } else {
            res.add(value);
            ptr++;
            while (ptr < arr.length && arr[ptr] != null) {
                res.add(arr[ptr]);
                ptr++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N1656_2OrderedStream obj = new N1656_2OrderedStream(5);
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
