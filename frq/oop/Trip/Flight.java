public class Flight {

    private Time departure, arrival;

    public Flight(Time departure, Time arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Time getDepartureTime() {
        return departure;
    }

    public Time getArrivalTime() {
        return arrival;
    }
}
