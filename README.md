# Problem 2: Virtual Memory Managment Problem

The virtual memory managment problem relates to the efficiency of various page replacement methods whilst retrieving pages from virtual memory.
The following list contains the common page replacement algorithms that are tested in this program:
* FIFO - First page brought in, is the first page to be replaced
* LRU - Replaces the least recently used page
* MRU - Replaces the most recently used page
* Optimal - Looks ahead and replaces the page that will not be used for the longest period of time

## How to Build and Run

A jar file is provided, and can be run via `java -jar CS471ProjectVMEMMAN-1.0-SNAPSHOT.jar i p f`.
This project can be recompiled into a jar file via `./gradlew jar` or run via `./gradlew run --args "i p f"`.

## Sample commands

`java -jar CS471ProjectVMEMMAN-1.0-SNAPSHOT.jar i p f` where i is the input file name, p is the page size, and f is number 
of frames allocated. 