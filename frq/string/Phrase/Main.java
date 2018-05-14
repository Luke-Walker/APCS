public class Main {

    public static void main(String[] args) {
        Phrase p1 = new Phrase("A cat ate late.");
        p1.replaceNthOccurrence("at", 1, "rane");
        System.out.println(p1);

        Phrase p2 = new Phrase("aaaa");
        p2.replaceNthOccurrence("aa", 1, "xx");
        System.out.println(p2);
    }
}
