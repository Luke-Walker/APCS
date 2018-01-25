public class Article extends Text {

  private String periodical;

  public Article(String t, String a, int y, String p) {
      super(t, a, y);
      periodical = p;
  }

  public String getPeriodical() {
      return periodical;
  }

  public String toString() {
    return super.toString() + " | " + periodical;
  }
}
