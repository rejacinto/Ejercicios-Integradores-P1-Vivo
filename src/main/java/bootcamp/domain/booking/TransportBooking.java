package bootcamp.domain.booking;

public class TransportBooking extends Booking {
    public TransportBooking(double count) {
        super(count);
    }

    @Override
    public String getKey() {
        return "Transporte";
    }
}
