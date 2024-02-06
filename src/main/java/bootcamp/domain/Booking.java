package bootcamp.domain;

public abstract class Booking {
    private Double price;

    public Booking(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "price=" + price +
                '}';
    }

}
