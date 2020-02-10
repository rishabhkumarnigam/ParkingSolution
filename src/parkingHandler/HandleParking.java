package parkingHandler;

import dto.Car;
import dto.ParkingBill;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class HandleParking {

    private TreeMap<Integer, Car> parking;
    private List<Boolean> filledSlotsOfParking;

    public HandleParking(int sizeOfParking) {
        this.parking = new TreeMap<Integer, Car>();
        this.filledSlotsOfParking = new ArrayList<>(sizeOfParking);
        for(int i=0;i<sizeOfParking;i++){
            this.filledSlotsOfParking.add(false);
        }
    }

    public static void main(String[] args) {

    }

    public int parkVehicle(Car car) {

        int toPark = filledSlotsOfParking.indexOf(false);
        if (toPark != -1) {
            parking.put(toPark+1, car);
            filledSlotsOfParking.remove(toPark);
            filledSlotsOfParking.add(toPark, true);
            return toPark;
        }
        return -1;

    }

    public ParkingBill removeVehicle(Car car,int hour) {

        if (parking.containsValue(car)) {
            Set<Integer> allParkedSlots = parking.keySet();
            for(int slot:allParkedSlots){
                if (parking.get(slot).equals(car)) {
                    parking.remove(slot);
                    filledSlotsOfParking.remove(slot-1);
                    filledSlotsOfParking.add(slot-1, false);
                    return calculateBill(car,slot,hour);
                }
            }

        }

        return null;

    }

    private ParkingBill calculateBill(Car car,int i,int totalHours) {

        /*LocalTime timeOfParking = car.getTimeOfParking();
        long totalHours = Duration.between(LocalTime.now(), timeOfParking).toHours();
*/
        ParkingBill parkingBill = new ParkingBill(car,i);

        if (totalHours <= 2) {
            parkingBill.setAmount(10);
        } else {
            totalHours = totalHours - 2;
            parkingBill.setAmount(totalHours * 10 + 10);
        }
        return parkingBill;
    }

    public TreeMap<Integer, Car> getStatus() {
        return this.parking;
    }
}
