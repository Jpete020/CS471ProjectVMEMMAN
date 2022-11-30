package replacement;

import java.util.ArrayList;

abstract public class ReplacementAlgorithm {
    protected ArrayList<Integer> frames;
    protected int framesAllocated;
    protected int pageSize;
    protected int totalPageFaults;
    protected int totalPageHits;


    protected ReplacementAlgorithm(int framesAllocated, int pageSize) {
        frames = new ArrayList<>(framesAllocated);
        this.framesAllocated = framesAllocated;
        this.pageSize = pageSize;
        this.totalPageHits = 0;
        this.totalPageFaults = 0;
    }

    protected int pageInFrames(int page) {
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i) == page) {
                return i;
            }
        }
        return -1;
    }

    protected abstract void pageHit(int page);

    protected abstract void pageFault(int page);

    protected void addPage(int page) {
        int frame = pageInFrames(page);
        if (frame != -1) {
            totalPageHits++;
            pageHit(page);
        } else {
            totalPageFaults++;
            pageFault(page);
        }
    }

    public int getTotalPageHits() {
        return totalPageHits;
    }

    public int getTotalPageFaults() {
        return totalPageFaults;
    }
}
