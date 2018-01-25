public class Website extends Text {

    private String url;

    public Website(String t, String a, int y, String url) {
        super(t, a, y);
        this.url = url;
    }

    public String getURL() {
        return url;
    }

    @Override
    public String toString() {
        return super.toString() + " @ " + url;
    }
}
