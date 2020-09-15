public class O11MinArray {

    public int minArray1(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        return min2(numbers, 0, numbers.length - 1);
    }

    public int min2(int[] numbers, int start, int end) {
        if (start == end) {
            return numbers[start];
        }
        if ((start + 1) == end) {
            return numbers[start] < numbers[end] ? numbers[start] : numbers[end];
        }
        int mid = start + (end - start) / 2;
        if (numbers[mid] > numbers[end]) {
            return min2(numbers, mid, end);
        } else if (numbers[mid] < numbers[end]) {
            return min2(numbers, start, mid);
        } else {
            return min2(numbers, start, end-1);
        }
    }
}
