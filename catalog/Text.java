public class Text {

  public String title;
  public String author;
  public int year;

  public Text() {
    title = "";
    author = "";
    year = 0;
  }

  public Text(String t, String a, int y) {
    super();
    title = t;
    author = a;
    year = y;
  }

  public String toString() {
    return author + ", " + title + ", " + year;
  }

}
