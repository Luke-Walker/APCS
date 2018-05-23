public class MultPractice implements StudyPractice {

    private int a, b;

    public MultPractice(int a, int b)  {
        this.a = a;
        this.b = b;
    }

    public String getProblem() {
        return a + " TIMES " + b;
    }

    public void nextProblem() {
        b++;
    }
}
