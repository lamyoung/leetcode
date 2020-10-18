public class J0105OneEditAway {

    public boolean oneEditAway(String first, String second) {
        if (first == second) {
            return true;
        }
        int minus = first.length() - second.length();
        if (minus < -1 || minus > 1) {
            return false;
        }
        if (minus == 0) {
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (count == 0) {
                        count++;
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
        String longer;
        String shorter;
        if (minus == 1) {
            longer = first;
            shorter = second;
        } else {
            longer = second;
            shorter = first;
        }
        int count = 0;
        for (int i = 0, j = 0; i < longer.length() && j < shorter.length(); i++) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                if (count == 0) {
                    count++;
                    continue;
                } else {
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
