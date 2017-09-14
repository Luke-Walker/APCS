import java.lang.*;
public class MiddleString {
  public static void main(String[] args) {
    if (args.length != 1) return;
    String word = args[0];
    double place = word.length()/2;
    double remainder = place%1==0?.5:0;
    int first = (int)(place-remainder);
    int second = (int)(place+remainder);
    StringBuilder sb = new StringBuilder(word);
    sb.setCharAt(first,Character.toUpperCase(sb.charAt(first)));
    sb.setCharAt(second,Character.toUpperCase(sb.charAt(second)));
    System.out.println(sb.toString());
  }
}
