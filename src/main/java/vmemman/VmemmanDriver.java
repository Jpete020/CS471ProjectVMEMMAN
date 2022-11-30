package vmemman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class VmemmanDriver {

    public static void main(String[] args){
        BufferedReader reader;
        BufferedWriter writer;
        String inputFile = args[0];

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
