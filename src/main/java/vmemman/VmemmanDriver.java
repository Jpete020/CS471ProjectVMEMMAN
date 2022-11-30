package vmemman;

import java.io.*;

public class VmemmanDriver {

    public static void main(String[] args){
        BufferedReader reader;
        BufferedWriter writer;
        String inputFile = args[0];

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter("output.txt"));
            String line = reader.readLine();

            while (line != null) {
                writer.write(line);
                writer.newLine();
                // read next line
                line = reader.readLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
