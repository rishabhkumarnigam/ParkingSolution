package reader;

import dto.InstructionDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static constants.Constants.FILE_NAME_INPUT;

public class TxtParkingInstructionReader implements ParkingInstructionReader {

    public List<InstructionDto> readParkingData(){

        List<InstructionDto> instructions = new ArrayList<>();


        final Path path = Paths.get(FILE_NAME_INPUT);
        try {
            final List<String> stringsLines = Files.readAllLines(path);

            for (String instructionLine : stringsLines) {

                InstructionDto instructionDto = new InstructionDto();

                String[] instructionArray = instructionLine.split(" ");
                instructionDto.setInstructionType(instructionArray[0]);
                if (instructionArray.length == 2) {
                    instructionDto.setInstructionValue(instructionArray[1]);
                }
                else if(instructionArray.length==3){
                  instructionDto.setInstructionValue(instructionArray[1]+" "+instructionArray[2]);
                }

                instructions.add(instructionDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instructions;
    }
}