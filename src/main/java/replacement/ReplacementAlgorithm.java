package replacement;

import java.util.ArrayList;

abstract public class ReplacementAlgorithm {
    protected ArrayList<Integer> frames;
    private final int framesAllocated;
    private final int pageSize;
    private int totalPageFaults;
    private int totalPageHits;


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

    protected abstract void pageHit(int page, int frame);

    protected abstract void pageFault(int page);

    public void addPage(int address) {
        int page = address / pageSize;
        int frame = pageInFrames(page);
        if (frame != -1) {
            totalPageHits++;
            pageHit(page, frame);
        } else if (frames.size() < framesAllocated) {
            totalPageFaults++;
            frames.add(page);
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

    public int getFramesAllocated() {
        return framesAllocated;
    }

    public int getPageSize() {
        return pageSize;
    }
}
