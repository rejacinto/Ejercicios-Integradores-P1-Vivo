package bootcamp.domain.booking;

public class TicketsBooking extends Booking {
    public TicketsBooking(double count) {
        super(count);
    }

    @Override
    public String getKey() {
        return "Boletos de vuelos";
    }
}
