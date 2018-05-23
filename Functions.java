public class Functions {

    public static void main(String[] args) {
        System.out.println(add(1, 8));
        System.out.println(makeAbba("abc", "123"));
        System.out.println(getInitials("Luke", "Walker"));
    }

    public static int add(int a, int b) {
        return a+b;
    }

    public static String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    public static String getInitials(String first, String last) {
        return first.substring(0,1) + last.substring(0,1);
    }
}
