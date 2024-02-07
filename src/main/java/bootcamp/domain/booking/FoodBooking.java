package bootcamp.domain.booking;

public class FoodBooking extends Booking {
    public FoodBooking(double count) {
        super(count);
    }

    @Override
    public String getKey() {
        return "Comida";
    }
}
