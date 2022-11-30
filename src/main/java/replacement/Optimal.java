package replacement;

public class Optimal extends ReplacementAlgorithm {
    Optimal(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page) {

    }

    @Override
    protected void pageFault(int page) {

    }
}
