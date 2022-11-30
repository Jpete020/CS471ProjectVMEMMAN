package replacement;

import java.util.ArrayList;
import java.util.HashMap;

public class Optimal extends ReplacementAlgorithm {
    private HashMap<Integer, ArrayList<Integer>> optimalAddresses;

    Optimal(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
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

    }
}
