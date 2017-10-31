public class NestedLoops {

  public static void main(String[] args) {

    // #1 Example - visualizing the nested loop flow
    /*
    System.out.println("#1 Example - visualizing the nested loop flow");
    int numRows = 3;
    int numCols = 4;
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        System.out.print("(row " + row + ", col " + col + ") ");
        try {
          Thread.sleep(500); // in milliseconds
        }
        catch(Exception e) {}
      }
      System.out.println();
    }
    */


    // #2 Exercise : Fix the errors, it should count up to 5 minutes
    // a. add a space character between the seconds
    // b. create a new line after the 60 seconds have been printed
    // c. Is the number of seconds in each minute correct?
    /*
    System.out.println("#2 Exercise : Fix the errors, it should count up to 5 minutes");
    int seconds = 0;
    int minutes = 0;
    for (minutes = 0; minutes < 5; minutes++) {
      System.out.println("minutes: " + minutes + "\tseconds: ");
      for (seconds = 0; seconds <= 60; seconds++) {
        try {
          Thread.sleep(1000); // in milliseconds
        }
        catch(Exception e) {}

        System.out.print(seconds + " ");
      }
      System.out.println();
    }
    */


    // #3 Example : More than two nested loops
    /*
    System.out.println("#3 Example : More than two nested loops");
    int count = 0;
    for (int a = 0; a < 3; a++) {
      for (int b = 0; b < 3; b++) {
        for (int c = 0; c < 3; c++) {
          count++;
          System.out.println(count + " : " + a + "," + b + "," + c);

          try {
            Thread.sleep(250); // in milliseconds
          }
          catch(Exception e) {}
        }
      }
    }
    */

    // #4 Exercise - How many times does it print hello?  (Try to guess before printing)
    /*
    int i = 0;
    System.out.println("#4 Exercise - How many times does it print hello? (Try to guess before printing)");
    for (int a = 1; a < 10; a+=3) {
      for (int b = 95; b > 90; b--) {
        for (int c = 1; c <= 8; c*=2) {
          System.out.println("hello");
          i++;
          System.out.println(i);
        }
      }
    }
    //3*5*4=60
    */
  }

}
