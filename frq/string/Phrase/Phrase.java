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
        // 3
        int index = findNthOccurrence(str, n);
        // "A c"
        String s = phrase.substring(0, index);
        // "A crane"
        s += repl;
        // "A crane ate late."
        s += phrase.substring(s.length() + (str.length()-repl.length()), phrase.length());

        phrase = s;
    }

    public int findLastOccurrence(String str) {
        for (int i = phrase.length(); i > 0; i--) {
          if (findNthOccurrence(str, i) != -1) {
            return findNthOccurrence(str, i);
          }
        }
        return -1;
    }

    public String toString() {
        return phrase;
    }
}
