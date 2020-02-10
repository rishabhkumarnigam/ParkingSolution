package reader;

import dto.InstructionDto;

import java.net.URISyntaxException;
import java.util.List;

public interface ParkingInstructionReader {

  List<InstructionDto> readParkingData() throws URISyntaxException;
}