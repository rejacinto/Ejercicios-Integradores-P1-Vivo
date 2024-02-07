package bootcamp.domain.booking;

public class HotelBooking extends Booking {
    public HotelBooking(double count) {
        super(count);
    }

    @Override
    public String getKey() {
        return "Reserva de hotel";
    }
}
