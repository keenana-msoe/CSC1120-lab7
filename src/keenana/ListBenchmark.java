/*
 * Course: CSC 1120
 * Term: Spring 2024
 * Assignment: Lab 7
 * Name: Andrew Keenan
 * Created: 2-28-14
 */
package keenana;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Class with 2 public methods that works in conjunction with the benchmarker
 */
public class ListBenchmark {
    /**
     * The method that determines what the benchmarker shoudl so based off of the information
     * provided in the parameters
     * @param listType the type of list that needs to be benchmarked
     * @param operation the operation that list will preform
     * @param size the smallest size of the list
     * @param multiplier the amount the size is multiplied by for the next benchmark
     * @param numberOfTests the aamount of times the benchmark should take place
     * @return an array of longs that corresponds to the time it takes for each benchmark
     */
    public long[] runBenchmark(String listType, String operation, int size,
                               int multiplier, int numberOfTests){
        long[] benchmarks = new long[numberOfTests];
        long timeI;
        long timeF;
        int currentSize = size;
        for(int i = 0; i < numberOfTests; i++){
            Integer[] values = populate(currentSize);
            List<Integer> tested = typeOfList(listType, values);
            timeI = System.nanoTime();
            preformOperation(tested, operation);
            timeF = System.nanoTime();
            benchmarks[i] = timeF-timeI;
            currentSize *= multiplier;
        }

        return benchmarks;
    }
    private List<Integer> typeOfList(String s, Integer[] nums){
        return switch (s) {
            case "java.util.LinkedList" -> new LinkedList<>(Arrays.asList(nums));
            case "java.util.ArrayList" -> new ArrayList<>(Arrays.asList(nums));
            case "datastructures.LinkedList" -> new datastructures.LinkedList<>(nums);
            case "datastructures.LinkedListTurbo" -> new datastructures.LinkedListTurbo<>(nums);
            default -> new datastructures.ArrayList<>(nums);
        };
    }
    private Integer[] populate(int size){
        Integer[] nums = new Integer[size];
        for (int i = 0; i < size; i++){
            nums[i] = (int) (Math.random() * size);
        }
        return nums;
    }
    private void preformOperation(List<Integer> nums, String operation){
        final int scale = 100;
        int random = (int) (Math.random() * scale);
        if (operation.equals("addToFront")){
            nums.add(0, random);
        } else if (operation.equals("indexedContains")){
            int x = 0;
            for (int i = 0; i < nums.size() && x != random; i++){
                x = nums.get(i);
            }
        } else {
            boolean x = nums.contains(random);
        }
    }
    /**
     * a method built for the user to get help on entering command line args
     * @return returns a string with instructions on what each argument does and
     * how to make them
     */
    public String getHelp(){
        return """
                Argument 1:\s
                1. java.util.ArrayList\s
                 2. java.util.LinkedList\s
                 3. datastructures.ArrayList\s
                 4. datastructures.LinkedList\s
                5. datastructures.LinkedListTurbo\s
                 Argument 2:\s
                1. AddToFront\s
                 2. indexedContains\s
                 3. Contains\s
                 Argument 3: Smallest List size\s
                 Argument 4: The multiplicative factor\s
                Argument 5: The amount of Benchmarks""";
    }
}
