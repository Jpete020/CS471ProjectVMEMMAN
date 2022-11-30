package replacement;

import java.util.ArrayList;
import java.util.HashMap;

public class Optimal extends ReplacementAlgorithm {
    private final HashMap<Integer, ArrayList<Integer>> optimalAddresses;

    public Optimal(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
        optimalAddresses = new HashMap<>();
    }

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

    }

    @Override
    protected void pageFault(int page) {
        int lastIndex = currentPosition;
        int frameToReplace = -1;

        for (int i = 0; i < frames.size(); i++) {
            ArrayList<Integer> indices = optimalAddresses.get(frames.get(i));

            boolean flag = true;

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
            if (flag) {
                frameToReplace = i;
                break;
            }
        }

        frames.remove(frameToReplace);
        frames.add(page);
    }
}
