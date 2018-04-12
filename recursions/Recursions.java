public class Recursions {

    public static void main(String[] args) {
        System.out.println(reverse("TEST"));
    }

    public static String reverse(String str) {
        if (str.length() <= 1 || str == null) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
