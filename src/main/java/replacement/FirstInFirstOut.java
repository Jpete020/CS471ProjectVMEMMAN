package replacement;

public class FirstInFirstOut extends ReplacementAlgorithm {
    public FirstInFirstOut(int framesAllocated, int pageSize) {
        super(framesAllocated, pageSize);
    }

    @Override
    protected void pageHit(int page, int frame) {

    }

    @Override
    protected void pageFault(int page) {
        frames.remove(0);
        frames.add(page);
    }
}
