package dto;

import java.time.LocalTime;
import java.util.Objects;

public class Car {

    private String color;
    private String carNumber;
    private LocalTime timeOfParking;

    public Car(String color, String carNumber) {
        this.color = color;
        this.carNumber = carNumber;
        timeOfParking=LocalTime.now();
    }

    public Car(String carNumber) {
        this.carNumber = carNumber;
        this.color=null;
        timeOfParking=LocalTime.now();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    public LocalTime getTimeOfParking() {
        return timeOfParking;
    }

    public void setTimeOfParking(LocalTime timeOfParking) {
        this.timeOfParking = timeOfParking;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
