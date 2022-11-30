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

        int pageSize = 2048;
        int numberOfFrames = 12;

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

        
        System.out.println(fifo.pageFaultPercentage());
        System.out.println(lru.pageFaultPercentage());
        System.out.println(mru.pageFaultPercentage());
        System.out.println(optimal.pageFaultPercentage());
    }
}
