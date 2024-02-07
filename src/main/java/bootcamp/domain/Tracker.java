package bootcamp.domain;

import bootcamp.domain.booking.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Tracker {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private List<Booking> bookings;
    private Client client;

    public Tracker(Client client) {
        this.bookings = new ArrayList<>();
        this.client = client;
    }

    public Tracker(List<Booking> bookings, Client client) {
        this.bookings = bookings;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "bookings=" + bookings +
                ", client=" + client +
                ", total=" + getTotal() +
                '}';
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getTotal() {
        double accumulator = 0.0;
        for (Booking booking : bookings) {
            accumulator += booking.getPrice();
        }
        return accumulator;
    }

    public void addCompleteBooking(double hotelPrice, double foodPrice, double ticketsPrice, double transportPrice) {
        bookings.add(new HotelBooking(hotelPrice));
        bookings.add(new FoodBooking(foodPrice));
        bookings.add(new TicketsBooking(ticketsPrice));
        bookings.add(new TransportBooking(transportPrice));
    }

    public boolean hasCompleteTouristPackage(){
        List<Booking> hotelBookings = bookings.stream().filter(b -> b.getClass() == HotelBooking.class).collect(Collectors.toList());
        List<Booking> foodBookings = bookings.stream().filter(b -> b.getClass() == FoodBooking.class).collect(Collectors.toList());
        List<Booking> ticketsBookings = bookings.stream().filter(b -> b.getClass() == TicketsBooking.class).collect(Collectors.toList());
        List<Booking> transportBookings = bookings.stream().filter(b -> b.getClass() == TransportBooking.class).collect(Collectors.toList());
        return !hotelBookings.isEmpty() && !foodBookings.isEmpty() && !ticketsBookings.isEmpty() && !transportBookings.isEmpty();
    }
}
