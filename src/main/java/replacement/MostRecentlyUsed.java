package replacement;

public class MostRecentlyUsed extends ReplacementAlgorithm {
    MostRecentlyUsed(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page, int frame) {
        frames.remove(frame);
        frames.add(page);
    }

    @Override
    protected void pageFault(int page) {
        frames.remove(frames.size() - 1);
        frames.add(page);
    }

}
