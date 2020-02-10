package writter;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static constants.Constants.FILE_NAME_OUTPUT;

public class FileWritter implements ParkingWritter {

  @Override
  public void writeData(String parking) {

    Path path = Paths.get(FILE_NAME_OUTPUT);

    try {
      if(!Files.exists(path)){
        Files.createFile(path);
      }

      Files.write(path, parking.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
