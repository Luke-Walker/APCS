import java.util.*;

public class Trip {

    private List<Flight> flights;

    public Trip(List<Flight> flights) {
        this.flights = flights;
    }

    public int getDuration() {
        int sum = 0;

        if (flights.size() == 1) {
            Flight f = flights.get(0);
            return f.getArrivalTime().getTotalMinutes() - f.getDepartureTime().getTotalMinutes();
        } else if (flights.size() > 1) {
            Flight f1 = flights.get(0);
            Flight f2 = flights.get(flights.size()-1);
            return f2.getArrivalTime().getTotalMinutes() - f1.getDepartureTime().getTotalMinutes();
        }

        return 0;
    }

    public int getShortestLayover() {
        if (flights.size() == 1) return 0;

        int shortest = flights.get(1).getDepartureTime().getTotalMinutes() - flights.get(0).getArrivalTime().getTotalMinutes();
        for (int i = 0; i < flights.size()-1; i++) {
            Flight f1 = flights.get(i);
            Flight f2 = flights.get(i+1);
            int layover = f2.getDepartureTime().getTotalMinutes() - f1.getArrivalTime().getTotalMinutes();
            if (layover < shortest) shortest = layover;
        }

        return shortest;
    }
}
