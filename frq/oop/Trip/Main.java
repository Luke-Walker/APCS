import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<Flight>();
        flights.add(new Flight(new Time(11, 30), new Time(12, 15)));
        flights.add(new Flight(new Time(13, 15), new Time(15, 45)));
        flights.add(new Flight(new Time(16, 0), new Time(18, 45)));
        flights.add(new Flight(new Time(22, 15), new Time(23, 0)));

        Trip trip = new Trip(flights);
        System.out.println("Duration of Trip: " + trip.getDuration());
        System.out.println("Shortest Layover: " + trip.getShortestLayover());
    }
}
