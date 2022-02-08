package ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class decryptFileService {
    public static void decryptAndSaveContent(final String path) {
        String decryptedFileName = path.substring(0, path.lastIndexOf('.')) + ".dec";
        try (final FileReader inputFileReader = new FileReader(path);
             final FileWriter outputFileWriter = new FileWriter(decryptedFileName)) {
            int c;
            while ((c = inputFileReader.read()) != -1) {
                outputFileWriter.write(c + 1);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file was not found or can not be created because: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Some error occurs: " + e.getMessage());
        }
    }
}