package replacement;

import java.util.ArrayList;

abstract public class ReplacementAlgorithm {
    ArrayList<Integer> frames;
    int framesAllocated;
    int pageSize;

    ReplacementAlgorithm(int framesAllocated, int pageSize) {
        frames = new ArrayList<>(framesAllocated);
        this.framesAllocated = framesAllocated;
        this.pageSize = pageSize;
    }
    protected abstract void replace();
}
