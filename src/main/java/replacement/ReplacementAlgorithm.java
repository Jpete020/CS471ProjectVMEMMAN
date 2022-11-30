package replacement;

import java.util.ArrayList;

abstract public class ReplacementAlgorithm {
    protected ArrayList<Integer> frames;
    protected int currentPosition;
    private final int framesAllocated;
    private final int pageSize;
    private int totalPageFaults;
    private int totalPageHits;
    private int maxPages;


    protected ReplacementAlgorithm(int framesAllocated, int pageSize) {
        frames = new ArrayList<>(framesAllocated);
        this.framesAllocated = framesAllocated;
        this.pageSize = pageSize;
        this.totalPageHits = 0;
        this.totalPageFaults = 0;
        this.maxPages = 0;
    }

    protected int pageInFrames(int page) {
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i) == page) {
                return i;
            }
        }
        return -1;
    }

    public int convertAddressToPage(int address) {
        return address / pageSize;
    }

    protected abstract void pageHit(int page, int frame);

    protected abstract void pageFault(int page);

    public void addPage(int address) {
        int page = convertAddressToPage(address);

        maxPages = Math.max(page, maxPages);

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
        currentPosition++;
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

    public double pageFaultPercentage() {
        return totalPageFaults / (double) (totalPageHits + totalPageFaults);
    }

    public String toPrettyString() {
        return String.format(
                "%-15d %-15d %-40s %-15f",
                pageSize,
                maxPages,
                this.getClass(),
                pageFaultPercentage()
        );
    }

    @Override
    public String toString() {
        return "ReplacementAlgorithm{" +
                "frames=" + frames +
                ", currentPosition=" + currentPosition +
                ", framesAllocated=" + framesAllocated +
                ", pageSize=" + pageSize +
                ", totalPageFaults=" + totalPageFaults +
                ", totalPageHits=" + totalPageHits +
                '}';
    }
}
