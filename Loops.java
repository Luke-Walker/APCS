public class Loops {

  public static void main(String[] args) {
    int j = 10;
    while (j > 0) {
      j--;
      System.out.println(j);
    }

    for (int i = 10; i > 0; i--) {
      System.out.println(i);
    }

    long num = 2;
    for (int i = 0; i < 5; i++) {
      num*=num;
      System.out.println(num);
    }
  }
}
