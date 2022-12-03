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
        // Gather inputs
        String inputFile = args[0];
        int pageSize = Integer.parseInt(args[1]);
        int numberOfFrames = Integer.parseInt(args[2]);

        // Read addresses
        ArrayList<Integer> addresses = new ArrayList<>();
        BufferedReader reader;

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

        // Start the algorithms
        for (Integer address : addresses) {
            fifo.addPage(address);
            lru.addPage(address);
            mru.addPage(address);
            optimal.addPage(address);
        }

        // Output
        System.out.println(String.format("%-15s %-15s %-15s %-40s %-15s","Page Size","#of pages", "#of Frames","Page replacement ALG","Page fault percentage"));
        System.out.println(fifo.toPrettyString());
        System.out.println(lru.toPrettyString());
        System.out.println(mru.toPrettyString());
        System.out.println(optimal.toPrettyString());
        System.out.println();

    }
}
