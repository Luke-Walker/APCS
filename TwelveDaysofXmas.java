// ABSENT

public class TwelveDaysofXmas {

    public static final String[] xmas = {
        "A Partridge in a Pear Tree",
        "Two Turtle Doves",
        "Three French Hens",
        "Four Calling Birds",
        "Five Gold Rings",
        "Six Geese A-laying",
        "Seven Swans A-swimming",
        "Eight Maids A-milking",
        "Nine Ladies Dancing",
        "Ten Lords A-leaping",
        "Eleven Pipers Piping",
        "Twelve Drummers Drumming"
    };

    public static void main(String[] args) {
        for (int i = 0; i < xmas.length; i++) {
            System.out.println("On the " + (i+1) + " day of Christmas my true love gave to me...");
            for (int j = i; j >= 0; j--) {
                System.out.println(xmas[j]);
            }
            System.out.print("\n\n");
        }
    }
}
