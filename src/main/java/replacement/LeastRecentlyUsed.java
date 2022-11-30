package replacement;

public class LeastRecentlyUsed extends ReplacementAlgorithm {
    LeastRecentlyUsed(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page, int frame) {
        frames.remove(frame);
        frames.add(page);
    }

    @Override
    protected void pageFault(int page) {

    }
}
