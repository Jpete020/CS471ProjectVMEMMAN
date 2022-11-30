package replacement;

public class LeastRecentlyUsed extends ReplacementAlgorithm {
    public LeastRecentlyUsed(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page, int frame) {
        frames.remove(frame);
        frames.add(page);
    }

    @Override
    protected void pageFault(int page) {
        frames.remove(0);
        frames.add(page);
    }
}
