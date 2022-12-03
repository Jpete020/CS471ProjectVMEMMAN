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

    /**
     * An abstract replacement algorithm
     * @param framesAllocated Number of frames to be allocated
     * @param pageSize The page size
     */
    protected ReplacementAlgorithm(int framesAllocated, int pageSize) {
        frames = new ArrayList<>(framesAllocated);
        this.framesAllocated = framesAllocated;
        this.pageSize = pageSize;
        this.totalPageHits = 0;
        this.totalPageFaults = 0;
        this.maxPages = 0;
    }

    /**
     * Identify if the page exists in the frames
     * @param page An arbitrary page
     * @return Returns the index of the page in the frames if it exists, else -1
     */
    protected int pageInFrames(int page) {
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i) == page) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Converts an address into a page number
     * @param address An arbitrary address
     * @return The associated page
     */
    public int convertAddressToPage(int address) {
        return address / pageSize;
    }

    /**
     * The action to be performed on a page hit
     * @param page The given page
     * @param frame The frame where the page exists
     */
    protected abstract void pageHit(int page, int frame);

    /**
     * The action to be performed on a page fault
     * @param page The given page
     */
    protected abstract void pageFault(int page);

    /**
     * Add the next given page
     * @param address The given address
     */
    public void addPage(int address) {
        int page = convertAddressToPage(address);

        // Assume that the largest page value is the largest page
        maxPages = Math.max(page, maxPages);

        // Identify the frame
        int frame = pageInFrames(page);
        if (frame != -1) { // Page hit
            totalPageHits++;
            pageHit(page, frame);
        } else if (frames.size() < framesAllocated) { // Page fault, but free frames
            totalPageFaults++;
            frames.add(page);
        } else { // Page fault, no free frames
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

    /**
     * Gets the page fault rate
     * @return A double identifying the page fault rate
     */
    public double pageFaultPercentage() {
        return totalPageFaults / (double) (totalPageHits + totalPageFaults);
    }

    /**
     * A pretty way of displaying information about an algorithm
     * @return A string with the pretty output
     */
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
