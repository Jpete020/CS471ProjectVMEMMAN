package replacement;

public class LeastRecentlyUsed extends ReplacementAlgorithm {
    /**
     * Replaces the frame that was least recently used
     * @param framesAllocated The number of frames allocated
     * @param pageSize The page size
     */
    public LeastRecentlyUsed(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    /**
     * Push the hit frame to the end of the list
     * @param page The given page
     * @param frame The frame where the page exists
     */
    @Override
    protected void pageHit(int page, int frame) {
        frames.remove(frame);
        frames.add(page);
    }

    /**
     * Pop the frame that is at the front of the list
     * @param page The given page
     */
    @Override
    protected void pageFault(int page) {
        frames.remove(0);
        frames.add(page);
    }
}
