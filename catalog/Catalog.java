public class Catalog {

  public static void main(String[] args) {

    Text book1 = new Book();
    Text book2 = new Book("The Hobbit", "Tolkien", 2006, "Harper Collins");
    Book book3 = new Book("Democracy in America", "Tocqueville", 2003, "Penguin");
    Website site = new Website("Abc", "123", 2018, "www.google.com");
    Article article = new Article("Qwerty", "1010", 2000, "Times");

    System.out.println(book1);
    System.out.println(book2);
    System.out.println(book3);
    System.out.println(site);
    System.out.println(article);



  }


}
