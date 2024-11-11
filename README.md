# CSC1120 Labs 6 and 7

Each week you will be required to complete multiple commits that
build towards a complete lab solution. Note your instructor's due dates
associated with each commit.

## [Link to Lab 6 assignment](https://csse.msoe.us/csc1120/lab6)

* [ ] Commit 1 "Rename package"
    - Rename the package to your MSOE keenana
    - Add the `ListBenchmark` class
    - Stub out the two required methods and write JavaDoc comments for each
* [ ] Commit 2 "Command Line Input"
  Implement the `main()` method so that it parses the command line input and calls
  the `ListBenchmark.runBenchmarks()` method. You do not need to handle exceptions yet.
* [ ] Commit 3 "Private methods for ListBenchmark"
    - Identify private methods for the `ListBenchmark` class needed to complete the assignment
      (used as helper methods to complete the implementation of the two required public methods)
    - Stub out the methods and provide JavaDoc for the methods.
* [ ] Commit 4 "Benchmark Parameters for java.util benchmarks"
    - Implement the remaining requirements for the lab assignment.
    - Fill in values for the benchmarking parameters below for the first four listed (the `?? ?? ?? [??ns]` on each line)
* [ ] Commit 5 "Lab completed"
    - Fill in remaining values for the benchmarking parameters below (the `?? ?? ?? [??ns]` on each line)
    - Remove the dashes on this line when lab 6 is ready to be graded (and commit and push): DONE6

### Benchmark Parameters

 * `java.util.ArrayList` indexedContains 10 10 7 [7,245,600 ns]
 * `java.util.ArrayList` contains 10 10 7 [10,567,500 ns]
 * `java.util.LinkedList` indexedContains 10 10 7 [20,918,500 ns]
 * `java.util.LinkedList` contains 10 10 7 [29,532,400 ns]
 * `datastructures.ArrayList` indexedContains 10 10 7 [30,367,500 ns]
 * `datastructures.ArrayList` contains 10 10 7 [30,008,800 ns]
 * `datastructures.LinkedList` indexedContains 10 10 7 [19,365,300 ns]
 * `datastructures.LinkedList` contains 10 10 7 [39,215,100 ns]
 * `datastructures.LinkedListTurbo` indexedContains 10 10 7 [32,646,100 ns]
 * `datastructures.LinkedListTurbo` contains 10 10 7 [46,366,900 ns]

## [Link to Lab 7 assignment](https://csse.msoe.us/csc1120/lab7)

* [ ] Commit 1 "Create report document"
    - Create Word document for your report. Include a title page.
* [ ] Commit 2 "Big-O Analysis"
    - Add your Big-O analysis to the report
* [ ] Commit 3 "Convert to JavaFX Program"
    - Implement `BenchmarkerFX` which accepts commandline arguments as a JavaFX program
* [ ] Commit 4 "Display Chart in JavaFX"
    - Implement functionality to display a chart with the benchmarking results
* [ ] Commit 5 "Save PNG image"
    - Implement functionality to save chart as a PNG image in the `plots` folder
    - Add plots to the report
* [ ] Commit 6 "Lab completed"
    - Update your code based on feedback from your instructor (if available)
    - Finish all assignment requirements.

Remove the dashes on this line when lab 7 is ready to be graded (and commit and push): D-O-N-E-7

