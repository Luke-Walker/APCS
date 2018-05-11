public class Time {

    private int hour, minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHours() { return hour; }
    public int getMinutes() { return minute; }
    public int getTotalMinutes() { return hour*60 + minute; }

    public int minutesUntil(Time other) {
        return other.getTotalMinutes() - getTotalMinutes();
    }
}
