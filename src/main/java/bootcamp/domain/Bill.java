package bootcamp.domain;

import bootcamp.domain.booking.Booking;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private Integer id;
    private Client client;
    private List<Booking> bookings;

    public Bill(Client client) {
        this.client = client;
        this.bookings = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public double getTotal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", client=" + client +
                ", bookings=" + bookings +
                '}';
    }
}
