import dto.Car;
import dto.InstructionDto;
import dto.ParkingBill;
import parkingHandler.HandleParking;
import reader.ParkingInstructionReader;
import reader.TxtParkingInstructionReader;
import writter.FileWritter;
import writter.ParkingWritter;

import java.net.URISyntaxException;
import java.util.List;
import java.util.TreeMap;

public class ClientRunner {
    public static void main(String[] args) throws URISyntaxException {
        ParkingInstructionReader instruction = new TxtParkingInstructionReader();
        List<InstructionDto> instructionDtos = instruction.readParkingData();
        HandleParking handleParking = null;
        ParkingWritter fileWritter = new FileWritter();

        for (InstructionDto instructions : instructionDtos) {

            if (instructions.getInstructionType().equals("create_parking_lot")) {
                handleParking = new HandleParking(Integer.parseInt(instructions.getInstructionValue()));
                fileWritter.writeData("Created parking lot with " + instructions.getInstructionValue() + " slots\n");
            } else if (instructions.getInstructionType().equals("park")) {
                Car car = new Car(instructions.getInstructionValue());
                int slot = handleParking.parkVehicle(car);
                if(slot==-1){
                    fileWritter.writeData("Sorry, parking lot is full\n");
                }
                else {
                    fileWritter.writeData("Allocated slot number: " + (slot+1) + "\n");
                }
            } else if (instructions.getInstructionType().equals("leave")) {
                String[] allInsValue = instructions.getInstructionValue().split(" ");

                Car car = new Car(allInsValue[0]);
                ParkingBill parkingBill = handleParking.removeVehicle(car,Integer.parseInt(allInsValue[1]));
                if(parkingBill==null){
                 fileWritter.writeData("Registration number " + allInsValue[0] + " not found\n");
                }
                else {
                    fileWritter.writeData("Registration number" +
                            instructions.getInstructionValue() + "\nwith Slot Number " + parkingBill.getSlot() + " is free with Charge " +
                            parkingBill.getAmount() + "\n");
                }
            } else if (instructions.getInstructionType().equals("status")) {
                TreeMap<Integer, Car> status = handleParking.getStatus();
                fileWritter.writeData("Slot No. Registration No.\n");

                for(Integer c:status.keySet()){
                    fileWritter.writeData(c+" "+status.get(c).getCarNumber()+"\n");
                }
            }
        }


    }
}