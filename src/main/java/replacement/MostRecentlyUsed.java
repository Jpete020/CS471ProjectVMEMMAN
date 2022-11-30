package replacement;

public class MostRecentlyUsed extends ReplacementAlgorithm {
    MostRecentlyUsed(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page, int frame) {

    }

    @Override
    protected void pageFault(int page) {

    }

}
