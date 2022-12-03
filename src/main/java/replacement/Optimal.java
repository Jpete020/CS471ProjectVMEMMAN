package replacement;

import java.util.ArrayList;
import java.util.HashMap;

public class Optimal extends ReplacementAlgorithm {
    private final HashMap<Integer, ArrayList<Integer>> optimalAddresses;

    /**
     * Replaces the page in the frames that appears last after the current position
     * @param framesAllocated The number of frames allocated
     * @param pageSize The page size
     */
    public Optimal(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
        optimalAddresses = new HashMap<>();
    }

    /**
     * Precomputes the page for each index in the list of addresses and store them in a map
     * @param addresses The list of addresses
     */
    public void loadAddress(ArrayList<Integer> addresses) {
        for (int i = 0; i < addresses.size(); i++) {
            int page = convertAddressToPage(addresses.get(i));
            ArrayList<Integer> result;

            if (optimalAddresses.containsKey(page)) {
                result = optimalAddresses.get(page);
            } else {
                result = new ArrayList<>();
            }

            result.add(i);
            optimalAddresses.put(page, result);
        }
    }

    @Override
    protected void pageHit(int page, int frame) {
        // Do nothing
    }

    @Override
    protected void pageFault(int page) {
        int lastIndex = currentPosition;
        int frameToReplace = -1;

        // For each frame
        for (int i = 0; i < frames.size(); i++) {
            ArrayList<Integer> indices = optimalAddresses.get(frames.get(i));

            boolean flag = true;

            // Find the next index after the current position
            for (Integer index : indices) {
                if (index > currentPosition) {
                    if (index > lastIndex) {
                        lastIndex = index;
                        frameToReplace = i;
                    }

                    flag = false;

                    break;
                }
            }

            // If the page does not appear after current position replace this frame
            if (flag) {
                frameToReplace = i;
                break;
            }
        }

        // Replace the frame
        frames.remove(frameToReplace);
        frames.add(page);
    }
}
