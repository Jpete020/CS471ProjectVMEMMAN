package replacement;

public class FirstInFirstOut extends ReplacementAlgorithm {
    FirstInFirstOut(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page) {

    }

    @Override
    protected void pageFault(int page) {
        frames.remove(0);
        frames.add(page);
    }
}
