package replacement;

public class LeastRecentlyUsed extends ReplacementAlgorithm {
    LeastRecentlyUsed(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page) {

    }

    @Override
    protected void pageFault(int page) {

    }
}
