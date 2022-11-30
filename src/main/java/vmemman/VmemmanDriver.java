package vmemman;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class VmemmanDriver {

    public static void main(String[] args){
        String inputFile = args[0];
        ArrayList<Integer> addresses = new ArrayList<>();
        BufferedReader reader;
        BufferedWriter writer;

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter("output.txt"));
            String line = reader.readLine();

            while (line != null) {
                addresses.add(parseInt(line));
                //writer.write(line);
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
