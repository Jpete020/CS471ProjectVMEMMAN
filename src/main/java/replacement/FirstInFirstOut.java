package replacement;

public class FirstInFirstOut extends ReplacementAlgorithm {
    /**
     * Replace the first frame to be allocated
     * @param framesAllocated The number of frames allocated
     * @param pageSize The page size
     */
    public FirstInFirstOut(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    /**
     * Does nothing
     * @param page The given page
     * @param frame The frame where the page exists
     */
    @Override
    protected void pageHit(int page, int frame) {
        // Do nothing
    }

    /**
     * Pop the first frame and add the page to the list
     * @param page The given page
     */
    @Override
    protected void pageFault(int page) {
        frames.remove(0);
        frames.add(page);
    }
}
