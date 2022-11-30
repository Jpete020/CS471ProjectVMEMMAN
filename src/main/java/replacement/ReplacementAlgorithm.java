package replacement;

import java.util.ArrayList;

abstract public class ReplacementAlgorithm {
    protected ArrayList<Integer> frames;
    protected int framesAllocated;
    protected int pageSize;
    protected int pageFaults;
    protected int pageHits;


    protected ReplacementAlgorithm(int framesAllocated, int pageSize) {
        frames = new ArrayList<>(framesAllocated);
        this.framesAllocated = framesAllocated;
        this.pageSize = pageSize;
        this.pageFaults = 0;
        this.pageHits = 0;
    }

    protected int pageInFrames(int page) {
        for (int i = 0; i < frames.size(); i++) {
            if (frames.get(i) == page) {
                return i;
            }
        }
        return -1;
    }

    protected abstract void replace(int page);

    protected void addPage(int page) {
        int frame = pageInFrames(page);
        if (frame != -1) {
            pageHits++;
        } else {
            pageFaults++;
            replace(page);
        }
    }
}
