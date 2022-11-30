package replacement;

public class Optimal extends ReplacementAlgorithm {
    Optimal(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page, int frame) {

    }

    @Override
    protected void pageFault(int page) {

    }
}
