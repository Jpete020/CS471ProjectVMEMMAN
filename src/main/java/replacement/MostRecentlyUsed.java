package replacement;

public class MostRecentlyUsed extends ReplacementAlgorithm {

    /**
     * Replaces the most recently used frame
     * @param framesAllocated The number of frames allocated
     * @param pageSize The page size
     */
    public MostRecentlyUsed(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    /**
     * Move the frame to the end of the list so that ona page fault it is easy to access
     * @param page The given page
     * @param frame The frame where the page exists
     */
    @Override
    protected void pageHit(int page, int frame) {
        frames.remove(frame);
        frames.add(page);
    }

    /**
     * Replace the frame at the end of the list
     * @param page The given page
     */
    @Override
    protected void pageFault(int page) {
        frames.remove(frames.size() - 1);
        frames.add(page);
    }

}
