import java.util.*;

public class Digits {

    private ArrayList<Integer> digitList;

    public Digits(int num) {
        digitList = new ArrayList<Integer>();

        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            digitList.add(Character.getNumericValue(c));
            System.out.println(digitList.get(i));
        }
    }

    public boolean isStrictlyIncreasing() {
        int last = digitList.get(0);
        for (int i : digitList) {
            if (i < last) return false;
            last = i;
        }
        return true;
    }
}
