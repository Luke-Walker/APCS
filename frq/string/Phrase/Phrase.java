public class Phrase {

    private String phrase;

    public Phrase(String phrase) {
        this.phrase = phrase;
    }

    public int findNthOccurrence(String str, int n) {
        String source = phrase;
        int i = 0, pos = 0, tpos = 0;

        while (i < n) {
            pos = source.indexOf(str);
            if (pos > -1) {
                source = source.substring(pos+1);
                tpos += pos+1;
                i++;
            } else {
                return -1;
            }
        }
        return tpos - 1;
    }

    public void replaceNthOccurrence(String str, int n, String repl) {
        /*int index = findNthOccurrence(str, n);
        System.out.println(index);
        String s = phrase.substring(0, index + (index == 0 ? str.length() : 0));
        System.out.println(s);
        s += repl;
        System.out.println(s);
        s += phrase.substring(s.length()-str.length(), phrase.length());
        phrase = s;*/

        // 3
        int index = findNthOccurrence(str, n);

        // "A c"
        String s = phrase.substring(0, index);
        // "A crane"
        s += repl;
    }

    public int findLastOccurrence(String str) {
        return 0;
    }

    public String toString() {
        return phrase;
    }
}
