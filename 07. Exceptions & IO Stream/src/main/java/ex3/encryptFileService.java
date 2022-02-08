package ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class encryptFileService {
    public static void encryptAndSaveContent(final String path) {
        String encryptedFileName = path.substring(0, path.lastIndexOf('.')) + ".enc";
        try (final FileReader inputFileReader = new FileReader(path);
             final FileWriter outputFileWriter = new FileWriter(encryptedFileName)) {
            // read data
            int c;
            while ((c = inputFileReader.read()) != -1) {
                outputFileWriter.write(c - 1);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file was not found or can not be created because: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Some error occurs: " + e.getMessage());
        }
    }
}