// https://www.reddit.com/r/dailyprogrammer/comments/6ze9z0/20170911_challenge_331_easy_the_adding_calculator/

import java.util.*;

public class AddingCalculator {

    public static void main(String[] args) {
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exponent");
        System.out.println("6. Exit");

        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.nextLine());
        System.out.println("Number 1: ");
        int num1 = Integer.parseInt(scan.nextLine());
        System.out.println("Number 2: ");
        int num2 = Integer.parseInt(scan.nextLine());
        int answer = 0;

        switch (choice) {
          case 1:
            answer = num1+num2;
            break;
          case 2:
            answer = num1+(-num2);
            break;
          case 3:
            for (int i = 0; i < num2; i++) {
              answer += num1;
            }
            break;
          case 4:
            for (int i = num1; i > 0; i-=num2) {
              answer += 1;
            }
            break;
          case 5:
            answer = num1;
            for (int i = num2; i > 0; i+=-1) {
              answer += num1;
            }
            break;
        }

        System.out.println(answer);
    }
}
