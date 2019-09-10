package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileOperations {
    // read the input file specified by -in command line argument
    static String readInput(String fileName){

        try{
            return readFileAsString(fileName);
        }catch (IOException e){
            System.out.printf(">>> Error Reading File: %s", e.getMessage());
            return null;
        }
    }//end of readInput

    // read file as a single String
    private static String readFileAsString(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }//end of readFileAsString

    // write output to file specified by -out command line argument
    static void writeOutput(String fileName, String finalData){

        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(finalData);
            System.out.println("Results Stored to file: " + fileName);
        } catch (IOException e) {
            System.out.printf(">>> Error Writing File: %s", e.getMessage());
        }
    }//end of writeOutput
}
