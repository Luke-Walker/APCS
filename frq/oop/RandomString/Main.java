public class Main {

    public static void main(String[] args) {
        String[] wordArray = {"wheels", "on", "the", "bus"};
        RandomString sChooser = new RandomString(wordArray);
        for (int k = 0; k < 6; k++)
        {
            System.out.print(sChooser.getNext() + " ");
        }
    }
}
