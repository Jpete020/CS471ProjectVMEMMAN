package vmemman;

import replacement.FirstInFirstOut;
import replacement.LeastRecentlyUsed;
import replacement.MostRecentlyUsed;
import replacement.Optimal;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class VmemmanDriver {

    public static void main(String[] args){
        String inputFile = args[0];
        int pageSize = Integer.parseInt(args[1]);
        int numberOfFrames = Integer.parseInt(args[2]);
        ArrayList<Integer> addresses = new ArrayList<>();
        BufferedReader reader;
        BufferedWriter writer;

        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();

            while (line != null) {
                addresses.add(parseInt(line));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Algorithms
        FirstInFirstOut fifo = new FirstInFirstOut(numberOfFrames, pageSize);
        LeastRecentlyUsed lru = new LeastRecentlyUsed(numberOfFrames, pageSize);
        MostRecentlyUsed mru = new MostRecentlyUsed(numberOfFrames, pageSize);
        Optimal optimal = new Optimal(numberOfFrames, pageSize);

        optimal.loadAddress(addresses);

        for (Integer address : addresses) {
            fifo.addPage(address);
            lru.addPage(address);
            mru.addPage(address);
            optimal.addPage(address);
        }

        try {
            writer = new BufferedWriter(new FileWriter(args[3]));

            writer.write(String.format("%-15s %-15s %-40s %-15s","Page Size","#of pages","Page replacement ALG","Page fault percentage"));
            writer.newLine();
            writer.write(fifo.toPrettyString());
            writer.newLine();
            writer.write(lru.toPrettyString());
            writer.newLine();
            writer.write(mru.toPrettyString());
            writer.newLine();
            writer.write(optimal.toPrettyString());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
