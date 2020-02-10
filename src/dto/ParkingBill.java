package dto;

public class ParkingBill {

    private long amount;
    private Car car;
    private int slot;

    public ParkingBill(int amount, Car car, int slot) {
        this.amount = amount;
        this.car = car;
        this.slot = slot;
    }

    public ParkingBill(Car car, int slot) {
        this.car = car;
        this.slot = slot;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
